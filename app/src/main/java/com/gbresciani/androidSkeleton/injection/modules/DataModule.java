package com.gbresciani.androidSkeleton.injection.modules;


import android.content.Context;

import com.gbresciani.androidSkeleton.data.DataManager;
import com.gbresciani.androidSkeleton.data.NetworkResourcesHelper;
import com.gbresciani.androidSkeleton.data.PreferenceHelper;

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
