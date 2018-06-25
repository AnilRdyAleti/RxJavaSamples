package com.example.anilreddy.rxjava.ui.pagination;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.anilreddy.rxjava.R;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.processors.PublishProcessor;

public class PaginationActivity extends AppCompatActivity {

    public static final String TAG = PaginationActivity.class.getSimpleName();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private PublishProcessor<Integer> paginator = PublishProcessor.create();
    private PaginationAdapter paginationAdaptor;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private boolean loading = false;
    private int pageNumber = 1;
    private final int VISIBLE_THRESHOLD = 1;
    private int lastVisibleItem, totalItemCount;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagination);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        paginationAdaptor = new PaginationAdapter();
        recyclerView.setAdapter(paginationAdaptor);
        setUpLoadMoreListener();
        subscribeForData();
    }

    private void subscribeForData() {
        Disposable disposable = paginator.onBackpressureDrop()
                .concatMap((Function<Integer, Publisher<List<String>>>) page -> {
                    loading = true;
                    progressBar.setVisibility(View.VISIBLE);
                    return dataFromNetwork(page);
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<List<String>>) items -> {
                    paginationAdaptor.addItems(items);
                    paginationAdaptor.notifyDataSetChanged();
                    loading = false;
                    progressBar.setVisibility(View.INVISIBLE);

                });
//        compositeDisposable.add(disposable);
//        paginator.onNext(pageNumber);
//        Disposable disposable = paginator.onBackpressureDrop()
//                .concatMap( (page) -> {
//                    loading = true;
//                    progressBar.setVisibility(View.VISIBLE);
//                    return dataFromNetwork(page);
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe((items) -> {
//                    paginationAdaptor.addItems(items);
//                    paginationAdaptor.notifyDataSetChanged();
//                    loading = false;
//                    progressBar.setVisibility(View.INVISIBLE);
//                });
//        compositeDisposable.add(disposable);
//        paginator.onNext(pageNumber);

    }

    private Flowable<List<String>> dataFromNetwork(final int page) {
        return Flowable.just(true)
                .delay(2, TimeUnit.SECONDS)
                .map(new Function<Boolean, List<String>>() {
                    @Override
                    public List<String> apply(Boolean value) throws Exception {
                        List<String> items = new ArrayList<>();
                        for (int i = 1; i <= 10; i++) {
                            items.add("Item " + (page * 10 + i));
                        }
                        return items;
                    }
                });
    }

    private void setUpLoadMoreListener() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = layoutManager.getItemCount();
                lastVisibleItem = layoutManager.findLastVisibleItemPosition();
                if (!loading && totalItemCount <= (lastVisibleItem + VISIBLE_THRESHOLD)) {
                    pageNumber++;
                    paginator.onNext(pageNumber);
                    loading = true;
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }


}
