package com.gbresciani.androidSkeleton.injection.modules;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private static Application app;

    public AppModule(Application application) {
        app = application;
    }

    @Provides
    Application provideApplication() {
        return app;
    }
}
