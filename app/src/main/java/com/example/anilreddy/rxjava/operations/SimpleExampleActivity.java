package com.example.anilreddy.rxjava.operations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.anilreddy.rxjava.R;

public class SimpleExampleActivity extends AppCompatActivity {

    private static final String TAG = SimpleExampleActivity.class.getName();
    Button btn;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_example);
        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);

        btn.setOnClickListener((v) -> {
            doSomeWork();
        });
    }

    private void doSomeWork() {

    }
}
