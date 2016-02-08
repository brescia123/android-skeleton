package com.cefriel.salmoiraghi150.ui.main;

import android.support.annotation.Nullable;

import com.cefriel.salmoiraghi150.ui.base.BasePresenter;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func0;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class MainPresenter extends BasePresenter<MainFragmentView> {

    @Nullable
    private String getGist() throws IOException {
        OkHttpClient client = new OkHttpClient();


        Request req = new Request.Builder()
                .url("https://gist.github.com/brescia123/f0593e16f13033749361")
                .build();

        Timber.i("Starting http call...", req.url());
        Response res = client.newCall(req).execute();
        Timber.i("Response code: %d", res.code());

        if (res.isSuccessful()) {
            Timber.d("", req.url());
            return res.body().string();
        }

        return String.valueOf(res.code());
    }

    public void loadGist() {
        getView().showProgress(true);
        getGistObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        if (getView() != null) getView().showProgress(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        if (getView() != null) getView().showText(s);
                    }
                });
    }

    public Observable<String> getGistObservable() {
        // Defer the execution until someone subscribe to the Observable
        return Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                try {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return Observable.just(getGist());
                } catch (IOException e) {
                    return null;
                }
            }
        });
    }
}
