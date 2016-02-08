package com.cefriel.salmoiraghi150.injection;

import com.cefriel.salmoiraghi150.ui.main.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {PresentersModule.class})
public interface PresentersComponent {
    void inject(MainFragment mainFragment);
}
