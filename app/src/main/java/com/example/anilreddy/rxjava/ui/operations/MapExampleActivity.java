package com.example.anilreddy.rxjava.ui.operations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.anilreddy.rxjava.R;
import com.example.anilreddy.rxjava.model.ApiUser;
import com.example.anilreddy.rxjava.model.User;
import com.example.anilreddy.rxjava.utils.AppConstant;
import com.example.anilreddy.rxjava.utils.Utils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MapExampleActivity extends AppCompatActivity {

    private static final String TAG = SimpleExampleActivity.class.getName();
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_example);

        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);

        btn.setOnClickListener((view) -> doSomeWork());
    }

    private void doSomeWork() {
        getObservable().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map((Function<List<ApiUser>, List<User>>) apiUser
                        -> Utils.convertApiUserListToUserList(apiUser)).subscribe(getObserver());

    }

    public Observable<List<ApiUser>> getObservable() {
        return Observable.create((e) -> {
            if (!e.isDisposed()) {
                e.onNext(Utils.getApiUserList());
                e.onComplete();
            }
        });
    }

    public Observer<List<User>> getObserver() {
        return new Observer<List<User>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(List<User> users) {
                textView.append(" onNext");
                textView.append(AppConstant.LINE_SEPARATOR);
                for (User user : users) {
                    textView.append("firstName: " + user.firstName);
                    textView.append(AppConstant.LINE_SEPARATOR);
                }
                Log.d(TAG, "onNext : " + users.size());
            }

            @Override
            public void onError(Throwable e) {
                textView.append(" onError" + e.getMessage());
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                textView.append(" onComplete");
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onComplete");
            }
        };
    }

}
