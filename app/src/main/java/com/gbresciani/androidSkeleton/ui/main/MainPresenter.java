package com.gbresciani.androidSkeleton.ui.main;

import com.gbresciani.androidSkeleton.data.DataManager;
import com.gbresciani.androidSkeleton.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

public class MainPresenter extends BasePresenter<MainFragmentView> {

    private DataManager dataManager;

    @Inject
    public MainPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(MainFragmentView view) {
        super.attachView(view);
        // This method is called every time the View is re-created (configuration changes; overriding
        // it allows us to inform the View of which "state" it has to display (e.g. one network
        // call is still alive and so the View has to display a ProgressBar)
        // TODO: move this to the @BasePresenter doc

    }

    public void loadGist() {
        getView().showProgress(true);
        dataManager.loadGist(true, true)
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        if (getView() != null) getView().showProgress(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, e.getMessage());
                    }

                    @Override
                    public void onNext(String s) {
                        if (getView() != null) getView().showText(s);
                    }
                });
    }
}
