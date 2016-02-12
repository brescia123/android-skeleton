package com.gbresciani.baseAndroidMVP.injection;

import com.gbresciani.baseAndroidMVP.ui.main.MainFragment;

import dagger.Component;

@Component(dependencies = {PresentersComponent.class})
public interface InjectorComponent {
    void inject(MainFragment mainFragment);
}
