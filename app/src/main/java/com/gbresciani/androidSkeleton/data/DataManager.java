package com.gbresciani.androidSkeleton.data;

import java.io.IOException;

import rx.Observable;
import rx.functions.Func0;

public class DataManager {

    private final PreferenceHelper preferenceHelper;
    private final NetworkResourcesHelper networkResourcesHelper;

    public DataManager(PreferenceHelper preferenceHelper, NetworkResourcesHelper networkResourcesHelper) {
        this.preferenceHelper = preferenceHelper;
        this.networkResourcesHelper = networkResourcesHelper;
    }

    public PreferenceHelper getPreferenceHelper() {
        return preferenceHelper;
    }

    public Observable<String> loadGist() {
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
                    return Observable.just(networkResourcesHelper.getGist());
                } catch (IOException e) {
                    return null;
                }
            }
        });
    }
}
