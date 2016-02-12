package com.gbresciani.baseAndroidMVP.data;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

public class PreferenceHelper {

    public static final String PREF_FILE_NAME = "base_android_MVP";

    private final SharedPreferences prefs;

    public PreferenceHelper(Context context) {
        prefs = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void clear() {
        prefs.edit().clear().apply();
    }
}
