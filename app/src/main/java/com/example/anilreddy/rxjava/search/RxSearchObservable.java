package com.example.anilreddy.rxjava.search;

import android.widget.SearchView;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

class RxSearchObservable {

    public RxSearchObservable() {

    }

    public static Observable<String> fromView(SearchView searchView) {

        final PublishSubject<String> subject = PublishSubject.create();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                subject.onComplete();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                subject.onNext(s);
                return true;
            }
        });
        return subject;
    }
}
