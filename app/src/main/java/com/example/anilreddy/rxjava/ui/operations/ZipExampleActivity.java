package com.example.anilreddy.rxjava.ui.operations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.anilreddy.rxjava.R;
import com.example.anilreddy.rxjava.model.User;
import com.example.anilreddy.rxjava.utils.AppConstant;
import com.example.anilreddy.rxjava.utils.Utils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ZipExampleActivity extends AppCompatActivity {

    public static final String TAG = ZipExampleActivity.class.getSimpleName();
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zip_example);
        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);

        btn.setOnClickListener((view) -> doSomeWork());
    }

    private void doSomeWork() {
        Observable.zip(getCricketFansObservable(), getFootballFansObservable(),
                //                (cricketFan, footballFan) ->
                //                    Utils.filterUserWhoLovesBoth(cricketFan, footballFan)
                Utils::filterUserWhoLovesBoth)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver());
    }

    public Observable<List<User>> getCricketFansObservable() {
        return Observable.create((e) -> {
            if (!e.isDisposed()) {
                e.onNext(Utils.getUserListWhoLovesCricket());
                e.onComplete();
            }
        });
    }

    public Observable<List<User>> getFootballFansObservable() {
        return Observable.create((e) -> {
            if (!e.isDisposed()) {
                e.onNext(Utils.getUserListWhoLovesFootball());
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
                textView.append(" onNext:");
                textView.append(AppConstant.LINE_SEPARATOR);
                for (User user : users) {
                    textView.append(" firstName: " + user.firstName);
                    textView.append(AppConstant.LINE_SEPARATOR);
                }
                Log.d(TAG, " onNext : " + users.size());
            }

            @Override
            public void onError(Throwable e) {
                textView.append(" onError : " + e.getMessage());
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onError : " + e.getMessage());
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
