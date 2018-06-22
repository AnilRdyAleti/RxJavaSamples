package com.example.anilreddy.rxjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startOperatorsActivity(View view) {
        startActivity(new Intent(this, OperatorsActivity.class));
    }

    public void startSearchActivity(View view) {
    }

    public void startComposeOperator(View view) {
    }

    public void startPaginationActivity(View view) {
    }

    public void startRxBusActivity(View view) {
    }

    public void startNetworkingActivity(View view) {
    }
}
