package com.gbresciani.baseAndroidMVP.ui.main;

import com.gbresciani.baseAndroidMVP.data.DataManager;
import com.gbresciani.baseAndroidMVP.ui.base.BasePresenter;

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

    public void loadGist() {
        getView().showProgress(true);
        dataManager.loadGist()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
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
