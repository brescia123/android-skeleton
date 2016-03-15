package it.gbresciani.androidSkeleton;

import android.app.Application;

import it.gbresciani.androidSkeleton.ui.DaggerPresentersComponent;
import it.gbresciani.androidSkeleton.injection.PresentersComponent;

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
