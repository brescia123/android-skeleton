package com.gbresciani.androidSkeleton.ui.base;

public class BasePresenter<V extends BaseView> implements Presenter<V> {

    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;

    }

    public boolean isViewAttached() {
        return view != null;
    }

    public V getView() {
        return view;
    }

}
