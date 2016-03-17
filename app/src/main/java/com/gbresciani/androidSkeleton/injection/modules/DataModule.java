package com.gbresciani.androidSkeleton.injection.modules;


import android.app.Application;
import android.content.Context;

import com.gbresciani.androidSkeleton.data.DataManager;
import com.gbresciani.androidSkeleton.data.NetworkResourcesHelper;
import com.gbresciani.androidSkeleton.data.PreferenceHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Singleton
    @Provides
    public PreferenceHelper providePreferenceHelper(Application context) {
        return new PreferenceHelper(context);
    }

    @Singleton
    @Provides
    public NetworkResourcesHelper provideNetworkResourcesHelper() {
        return new NetworkResourcesHelper();
    }

    @Singleton
    @Provides
    public DataManager provideDataManager(PreferenceHelper preferenceHelper, NetworkResourcesHelper networkResourcesHelper) {
        return new DataManager(preferenceHelper, networkResourcesHelper);
    }
}
