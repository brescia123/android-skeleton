package com.gbresciani.androidSkeleton.injection.components;

import com.gbresciani.androidSkeleton.injection.PresentersModule;
import com.gbresciani.androidSkeleton.injection.components.DataComponent;
import com.gbresciani.androidSkeleton.ui.main.MainPresenter;

import dagger.Component;

@Component(modules = {PresentersModule.class}, dependencies = DataComponent.class)
public interface PresentersComponent {
    MainPresenter getMainPresenter();
}
