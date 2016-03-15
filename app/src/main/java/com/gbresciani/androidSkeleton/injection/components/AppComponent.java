package com.gbresciani.androidSkeleton.injection.components;

import android.app.Application;

import com.gbresciani.androidSkeleton.injection.modules.AppModule;

import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {
    // Exposes Application to any component which depends on this
    Application getApp();
}
