package com.gbresciani.androidSkeleton;

import android.app.Application;

import com.gbresciani.androidSkeleton.injection.components.AppComponent;
import com.gbresciani.androidSkeleton.injection.components.DaggerAppComponent;
import com.gbresciani.androidSkeleton.injection.modules.AppModule;
import com.gbresciani.androidSkeleton.injection.modules.DataModule;

import timber.log.Timber;

public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        initAppComponent();
    }

    /**
     * Build the AppComponent creating the dependency modules.
     */
    private void initAppComponent() {
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule())
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
