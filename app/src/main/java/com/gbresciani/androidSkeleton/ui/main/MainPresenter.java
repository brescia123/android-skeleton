package com.gbresciani.androidSkeleton.ui.main;

import com.gbresciani.androidSkeleton.data.DataManager;
import com.gbresciani.androidSkeleton.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

public class MainPresenter extends BasePresenter<MainFragmentView> {

    private DataManager dataManager;

    // State variables, initialized with default values.
    private boolean state_loading = false;
    private String state_text = "";
    private CompositeSubscription subscriptions = new CompositeSubscription();

    @Inject
    public MainPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void bindView(MainFragmentView view) {
        super.bindView(view);
        restoreState();
    }

    @Override
    public void destroyView() {
        super.destroyView();
        subscriptions.clear();
    }

    public void loadGist() {
        state_loading = true;
        if (isViewBound()) getView().showProgress(state_loading);
        Subscription sub = dataManager.loadGist(true, true)
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
                        state_text = s;
                        if (getView() != null) getView().showText(state_text);
                    }
                });
        subscriptions.add(sub);
    }

    private void restoreState() {
        getView().showProgress(state_loading);
        getView().showText(state_text);
    }
}
