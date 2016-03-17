package com.gbresciani.androidSkeleton.ui.main;

import com.gbresciani.androidSkeleton.data.DataManager;
import com.gbresciani.androidSkeleton.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Subscriber;
import timber.log.Timber;

public class MainPresenter extends BasePresenter<MainFragmentView> {

    private DataManager dataManager;

    // State variables, initialized with default values.
    private boolean state_loading = false;
    private String state_text = "";

    @Inject
    public MainPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void bindView(MainFragmentView view) {
        super.bindView(view);
        restoreState();
    }

    public void loadGist() {
        state_loading = true;
        getView().showProgress(state_loading);
        dataManager.loadGist(true, true)
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        state_loading = false;
                        if (isViewBound()) getView().showProgress(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        if (getView() != null) {
                            state_text = s;
                            getView().showText(state_text);
                        }
                    }
                });
    }

    private void restoreState() {
        getView().showProgress(state_loading);
        getView().showText(state_text);
    }
}
