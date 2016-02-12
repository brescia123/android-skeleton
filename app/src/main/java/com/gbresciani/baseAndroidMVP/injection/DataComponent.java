package com.gbresciani.baseAndroidMVP.injection;

import com.gbresciani.baseAndroidMVP.data.DataManager;
import com.gbresciani.baseAndroidMVP.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {DataModule.class, AppModule.class}, dependencies = AppComponent.class)
public interface DataComponent {
    // Exposes DataManager to any component which depends on this
    DataManager getDataManager();
}
