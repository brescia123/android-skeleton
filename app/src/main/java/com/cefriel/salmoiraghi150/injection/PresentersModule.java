package com.cefriel.salmoiraghi150.injection;

import com.cefriel.salmoiraghi150.ui.main.MainPresenter;

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
