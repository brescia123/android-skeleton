package com.gbresciani.androidSkeleton.injection.components;

import com.gbresciani.androidSkeleton.injection.modules.PresentersModule;
import com.gbresciani.androidSkeleton.injection.scopes.ViewScope;
import com.gbresciani.androidSkeleton.ui.main.MainFragment;
import com.gbresciani.androidSkeleton.ui.main.MainPresenter;

import dagger.Component;
import dagger.Subcomponent;

@ViewScope
@Subcomponent(modules = PresentersModule.class)
public interface PresentersComponent {
    void inject(MainFragment mainFragment);
}
