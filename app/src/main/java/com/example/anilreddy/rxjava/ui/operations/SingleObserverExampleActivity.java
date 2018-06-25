package com.example.anilreddy.rxjava.ui.operations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.anilreddy.rxjava.R;
import com.example.anilreddy.rxjava.utils.AppConstant;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class SingleObserverExampleActivity extends AppCompatActivity {

    public static final String TAG = SingleObserverExampleActivity.class.getSimpleName();
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_sample);

        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);

        btn.setOnClickListener((v) -> doSomeWork());
    }

    private void doSomeWork() {
        Single.just("Amit").subscribe(getSingleObserver());

    }

    private SingleObserver<String> getSingleObserver() {
        return new SingleObserver<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onSuccess(String s) {
                textView.append(" onNext : value : " + s);
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onNext value : " + s);
            }

            @Override
            public void onError(Throwable e) {
                textView.append(" onError : " + e.getMessage());
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onError : " + e.getMessage());
            }
        };
    }
}
