package it.gbresciani.androidSkeleton.injection;

import it.gbresciani.androidSkeleton.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentersModule {

    @Singleton
    @Provides
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

}
