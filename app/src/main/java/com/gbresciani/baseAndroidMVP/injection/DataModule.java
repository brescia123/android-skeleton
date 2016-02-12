package com.gbresciani.baseAndroidMVP.injection;


import android.content.Context;

import com.gbresciani.baseAndroidMVP.data.DataManager;
import com.gbresciani.baseAndroidMVP.data.NetworkResourcesHelper;
import com.gbresciani.baseAndroidMVP.data.PreferenceHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    public PreferenceHelper providePreferenceHelper(Context context) {
        return new PreferenceHelper(context);
    }

    @Provides
    public NetworkResourcesHelper provideNetworkResourcesHelper() {
        return new NetworkResourcesHelper();
    }

    @Provides
    public DataManager provideDataManager(PreferenceHelper preferenceHelper, NetworkResourcesHelper networkResourcesHelper) {
        return new DataManager(preferenceHelper, networkResourcesHelper);
    }
}
