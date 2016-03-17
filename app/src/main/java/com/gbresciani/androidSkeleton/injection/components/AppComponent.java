package com.gbresciani.androidSkeleton.injection.components;

import android.app.Application;

import com.gbresciani.androidSkeleton.data.DataManager;
import com.gbresciani.androidSkeleton.injection.modules.AppModule;
import com.gbresciani.androidSkeleton.injection.modules.DataModule;
import com.gbresciani.androidSkeleton.injection.modules.PresentersModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {

    // Since PresentersComponent is subComponent the dependencies are automatically exposed to it
    PresentersComponent plus(PresentersModule presentersModule);
}
