package com.gbresciani.androidSkeleton.injection.modules;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private static Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    Context provideContext() {
        return application.getApplicationContext();
    }
}
