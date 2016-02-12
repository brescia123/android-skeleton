package com.gbresciani.baseAndroidMVP.injection;

import com.gbresciani.baseAndroidMVP.ui.main.MainFragment;
import com.gbresciani.baseAndroidMVP.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {PresentersModule.class}, dependencies = DataComponent.class)
public interface PresentersComponent {
    MainPresenter getMainPresenter();
}
