package com.gbresciani.androidSkeleton.injection.components;

import com.gbresciani.androidSkeleton.data.DataManager;
import com.gbresciani.androidSkeleton.injection.modules.AppModule;
import com.gbresciani.androidSkeleton.injection.modules.DataModule;

import dagger.Component;

@Component(modules = DataModule.class, dependencies = AppComponent.class)
public interface DataComponent {
    // Exposes DataManager to any component which depends on this
    DataManager getDataManager();
}
