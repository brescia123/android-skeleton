package it.gbresciani.androidSkeleton.injection;

import it.gbresciani.androidSkeleton.ui.main.MainFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {PresentersModule.class})
public interface PresentersComponent {
    void inject(MainFragment mainFragment);
}
