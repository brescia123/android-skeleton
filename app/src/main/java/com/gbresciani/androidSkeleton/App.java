package com.gbresciani.androidSkeleton;

import android.app.Application;

import com.gbresciani.androidSkeleton.injection.components.AppComponent;
import com.gbresciani.androidSkeleton.injection.components.DaggerAppComponent;
import com.gbresciani.androidSkeleton.injection.components.DaggerPresentersComponent;
import com.gbresciani.androidSkeleton.injection.components.PresentersComponent;
import com.gbresciani.androidSkeleton.injection.modules.AppModule;
import com.gbresciani.androidSkeleton.injection.modules.DataModule;

import timber.log.Timber;

public class App extends Application {

    private static PresentersComponent presentersComponent;
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        AppModule appModule = new AppModule(this);
        DataModule dataModule = new DataModule();


        appComponent = DaggerAppComponent
                .builder()
                .appModule(appModule)
                .dataModule(dataModule)
                .build();

        presentersComponent = DaggerPresentersComponent
                .builder()
                .appComponent(appComponent)
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static PresentersComponent getPresentersComponent() {
        return presentersComponent;
    }
}
