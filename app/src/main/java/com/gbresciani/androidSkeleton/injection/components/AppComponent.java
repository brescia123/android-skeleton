package com.gbresciani.androidSkeleton.injection.components;

import android.app.Application;

import com.gbresciani.androidSkeleton.data.DataManager;
import com.gbresciani.androidSkeleton.injection.modules.AppModule;
import com.gbresciani.androidSkeleton.injection.modules.DataModule;

import dagger.Component;

@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {
    // Exposes Application to any component which depends on this
    Application getApp();

    // Exposes DataManager to any component which depends on this
    DataManager getDataManager();
}
