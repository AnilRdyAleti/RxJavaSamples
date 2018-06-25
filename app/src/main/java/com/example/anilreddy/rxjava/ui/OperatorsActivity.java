package com.example.anilreddy.rxjava.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.anilreddy.rxjava.R;
import com.example.anilreddy.rxjava.ui.operations.CompletableObserverExampleActivity;
import com.example.anilreddy.rxjava.ui.operations.DisposableExampleActivity;
import com.example.anilreddy.rxjava.ui.operations.IntervalExampleActivity;
import com.example.anilreddy.rxjava.ui.operations.MapExampleActivity;
import com.example.anilreddy.rxjava.ui.operations.SimpleExampleActivity;
import com.example.anilreddy.rxjava.ui.operations.SingleObserverExampleActivity;
import com.example.anilreddy.rxjava.ui.operations.TakeExampleActivity;
import com.example.anilreddy.rxjava.ui.operations.ZipExampleActivity;
import com.example.anilreddy.rxjava.ui.operations.startTimerActivity;


public class OperatorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operators);
    }

    public void startSimpleActivity(View view) {
        startActivity(new Intent(this, SimpleExampleActivity.class));
    }

    public void startMapActivity(View view) {
        startActivity(new Intent(this, MapExampleActivity.class));
    }

    public void startZipActivity(View view) {
        startActivity(new Intent(this, ZipExampleActivity.class));
    }

    public void startDisposableActivity(View view) {
        startActivity(new Intent(this, DisposableExampleActivity.class));
    }

    public void startTakeActivity(View view) {
        startActivity(new Intent(this, TakeExampleActivity.class));
    }

    public void startTimerActivity(View view) {
        startActivity(new Intent(this, startTimerActivity.class));
    }

    public void startIntervalActivity(View view) {
        startActivity(new Intent(this, IntervalExampleActivity.class));
    }

    public void startSingleObserverActivity(View view) {
        startActivity(new Intent(this, SingleObserverExampleActivity.class));
    }

    public void startCompletableObserverActivity(View view) {
        startActivity(new Intent(this, CompletableObserverExampleActivity.class));
    }

    public void startFlowableActivity(View view) {
    }

    public void startReduceActivity(View view) {
    }

    public void startBufferActivity(View view) {
    }

    public void startFilterActivity(View view) {
    }

    public void startSkipActivity(View view) {
    }

    public void startScanActivity(View view) {
    }

    public void startReplayActivity(View view) {
    }

    public void startConcatActivity(View view) {
    }

    public void startMergeActivity(View view) {
    }

    public void startDeferActivity(View view) {
    }

    public void startDistinctActivity(View view) {
    }

    public void startLastOperatorActivity(View view) {
    }

    public void startReplaySubjectActivity(View view) {
    }

    public void startPublishSubjectActivity(View view) {
    }

    public void startBehaviorSubjectActivity(View view) {
    }

    public void startAsyncSubjectActivity(View view) {
    }

    public void startThrottleFirstActivity(View view) {
    }

    public void startThrottleLastActivity(View view) {
    }

    public void startDebounceActivity(View view) {
    }

    public void startWindowActivity(View view) {
    }

    public void startDelayActivity(View view) {
    }
}
