package com.gbresciani.androidSkeleton.injection.modules;

import com.gbresciani.androidSkeleton.data.DataManager;
import com.gbresciani.androidSkeleton.injection.scopes.ViewScope;
import com.gbresciani.androidSkeleton.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentersModule {

    @ViewScope
    @Provides
    public MainPresenter provideMainPresenter(DataManager dataManager) {
        return new MainPresenter(dataManager);
    }

}
