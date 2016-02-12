package com.gbresciani.baseAndroidMVP.injection;

import com.gbresciani.baseAndroidMVP.data.DataManager;
import com.gbresciani.baseAndroidMVP.ui.main.MainPresenter;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentersModule {

    @Provides
    public MainPresenter provideMainPresenter(DataManager dataManager) {
        return new MainPresenter(dataManager);
    }

}
