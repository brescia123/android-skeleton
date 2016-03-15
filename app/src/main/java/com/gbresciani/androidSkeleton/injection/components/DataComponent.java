package com.gbresciani.androidSkeleton.injection.components;

import com.gbresciani.androidSkeleton.data.DataManager;
import com.gbresciani.androidSkeleton.injection.AppModule;
import com.gbresciani.androidSkeleton.injection.DataModule;
import com.gbresciani.androidSkeleton.injection.components.AppComponent;

import dagger.Component;

@Component(modules = {DataModule.class, AppModule.class}, dependencies = AppComponent.class)
public interface DataComponent {
    // Exposes DataManager to any component which depends on this
    DataManager getDataManager();
}
