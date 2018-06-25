package com.example.anilreddy.rxjava.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.anilreddy.rxjava.MyApplication;
import com.example.anilreddy.rxjava.R;
import com.example.anilreddy.rxjava.ui.pagination.PaginationActivity;
import com.example.anilreddy.rxjava.ui.rxbus.RxBusActivity;
import com.example.anilreddy.rxjava.ui.search.SearchActivity;

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
        startActivity(new Intent(this, SearchActivity.class));
    }

    public void startComposeOperator(View view) {
    }

    public void startPaginationActivity(View view) {
        startActivity(new Intent(this, PaginationActivity.class));
    }

    public void startRxBusActivity(View view) {
        ((MyApplication) getApplication()).sendAutoEvent();
        startActivity(new Intent(this, RxBusActivity.class));
    }

    public void startNetworkingActivity(View view) {
    }
}
