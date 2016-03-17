package com.gbresciani.androidSkeleton.data;

import android.util.LruCache;

import java.io.IOException;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func0;
import rx.schedulers.Schedulers;

public class DataManager {

    private static final String LOAD_GIST = "loadGistKey";

    private final PreferenceHelper preferenceHelper;
    private final NetworkResourcesHelper networkResourcesHelper;

    private LruCache<String, Observable<?>> dataObservables;

    public DataManager(PreferenceHelper preferenceHelper, NetworkResourcesHelper networkResourcesHelper) {
        this.preferenceHelper = preferenceHelper;
        this.networkResourcesHelper = networkResourcesHelper;
        dataObservables = new LruCache<>(10);
    }

    public PreferenceHelper getPreferenceHelper() {
        return preferenceHelper;
    }

    public Observable<String> loadGist(boolean useCache, boolean cacheObservable) {

        Observable<String> gistObservable;

        // Try to restore from cache
        if (useCache) {
            gistObservable = (Observable<String>) dataObservables.get(LOAD_GIST);
            if (gistObservable != null) {
                return gistObservable;
            }
        }

        // Create the observable
        gistObservable = Observable
                 // Defer the execution until someone subscribe to the Observable
                 .defer(new Func0<Observable<String>>() {
                    @Override
                    public Observable<String> call() {
                        try {
                            try {
                                Thread.sleep(4000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            return Observable.just(networkResourcesHelper.getGist());
                        } catch (IOException e) {
                            return null;
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        // Cache the observable
        if (cacheObservable) {
            gistObservable = gistObservable.cache();
            dataObservables.put(LOAD_GIST, gistObservable);
        }

        return gistObservable;
    }
}
