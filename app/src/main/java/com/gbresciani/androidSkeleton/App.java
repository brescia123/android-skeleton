package com.gbresciani.androidSkeleton;

import android.app.Application;

import com.gbresciani.androidSkeleton.injection.AppComponent;
import com.gbresciani.androidSkeleton.injection.AppModule;
import com.gbresciani.androidSkeleton.injection.DaggerAppComponent;
import com.gbresciani.androidSkeleton.injection.DaggerDataComponent;
import com.gbresciani.androidSkeleton.injection.DaggerPresentersComponent;
import com.gbresciani.androidSkeleton.injection.DataComponent;
import com.gbresciani.androidSkeleton.injection.DataModule;
import com.gbresciani.androidSkeleton.injection.PresentersComponent;

import timber.log.Timber;

public class App extends Application {

    private static PresentersComponent presentersComponent;
    private static DataComponent dataComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        AppModule appModule = new AppModule(this);
        DataModule dataModule = new DataModule();

        AppComponent appComponent = DaggerAppComponent
                .builder()
                .appModule(appModule)
                .build();

        dataComponent = DaggerDataComponent
                .builder()
                .appModule(appModule)
                .appComponent(appComponent)
                .build();

        presentersComponent = DaggerPresentersComponent
                .builder()
                .dataComponent(dataComponent)
                .build();
    }

    public static DataComponent getDataComponent() {
        return dataComponent;
    }

    public static PresentersComponent getPresentersComponent() {
        return presentersComponent;
    }
}
