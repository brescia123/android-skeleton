package com.cefriel.salmoiraghi150;

import android.app.Application;

import com.cefriel.salmoiraghi150.ui.DaggerPresentersComponent;
import com.cefriel.salmoiraghi150.injection.PresentersComponent;

import timber.log.Timber;

public class App extends Application {

    private PresentersComponent presentersComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        presentersComponent = DaggerPresentersComponent.builder()
                .build();
    }

    public PresentersComponent getPresentersComponent() {
        return presentersComponent;
    }
}
