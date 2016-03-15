package com.gbresciani.androidSkeleton.injection.components;

import com.gbresciani.androidSkeleton.injection.modules.PresentersModule;
import com.gbresciani.androidSkeleton.ui.main.MainFragment;
import com.gbresciani.androidSkeleton.ui.main.MainPresenter;

import dagger.Component;

@Component(modules = PresentersModule.class, dependencies = AppComponent.class)
public interface PresentersComponent {
    MainPresenter getMainPresenter();
    void inject(MainFragment mainFragment);
}
