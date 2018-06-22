package com.example.anilreddy.rxjava.operations;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.anilreddy.rxjava.R;
import com.example.anilreddy.rxjava.utils.AppConstant;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class DisposableExampleActivity extends AppCompatActivity {

    private static final String TAG = DisposableExampleActivity.class.getSimpleName();
    Button btn;
    TextView textView;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_sample);
        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);

        btn.setOnClickListener((view) -> doSomeWork());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }

    private void doSomeWork() {
        compositeDisposable.add(sampleObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<String>() {
                    @Override
                    public void onNext(String value) {
                        textView.append(" onError : " + value);
                        textView.append(AppConstant.LINE_SEPARATOR);
                        Log.d(TAG, " onError : " + value);
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
                }));
    }

    private Observable<String> sampleObservable() {
        return Observable.defer(() -> {
            SystemClock.sleep(2000);
            return Observable.just("one", "two", "three", "four", "five");
        });
    }
}
