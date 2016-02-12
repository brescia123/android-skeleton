package com.gbresciani.baseAndroidMVP;

import android.app.Application;

import com.gbresciani.baseAndroidMVP.injection.AppComponent;
import com.gbresciani.baseAndroidMVP.injection.AppModule;
import com.gbresciani.baseAndroidMVP.injection.DaggerAppComponent;
import com.gbresciani.baseAndroidMVP.injection.DaggerDataComponent;
import com.gbresciani.baseAndroidMVP.injection.DaggerPresentersComponent;
import com.gbresciani.baseAndroidMVP.injection.DataComponent;
import com.gbresciani.baseAndroidMVP.injection.DataModule;
import com.gbresciani.baseAndroidMVP.injection.PresentersComponent;

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
