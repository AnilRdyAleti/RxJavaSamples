package com.example.anilreddy.rxjava.operations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.anilreddy.rxjava.R;

public class IntervalExampleActivity extends AppCompatActivity {

    private final static String TAG = startTimerActivity.class.getSimpleName();
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_sample);

        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);

        btn.setOnClickListener((view) -> doSomeWork());
    }

    private void doSomeWork() {
        
    }
}
