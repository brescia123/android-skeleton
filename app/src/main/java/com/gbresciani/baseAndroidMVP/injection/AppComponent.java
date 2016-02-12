package com.gbresciani.baseAndroidMVP.injection;

import android.app.Application;

import com.gbresciani.baseAndroidMVP.App;
import com.gbresciani.baseAndroidMVP.data.PreferenceHelper;
import com.gbresciani.baseAndroidMVP.ui.main.MainActivity;
import com.gbresciani.baseAndroidMVP.ui.main.MainFragment;
import com.gbresciani.baseAndroidMVP.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {
    // Exposes Application to any component which depends on this
    Application getApp();
}
