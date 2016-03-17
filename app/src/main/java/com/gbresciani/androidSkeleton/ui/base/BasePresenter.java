package com.gbresciani.androidSkeleton.ui.base;

/**
 * Base Class for all the presenters. It takes care of implementing the attach/detach view mechanism.
 *
 * @param <V> The type of view the presenter is controlling.
 */
public class BasePresenter<V extends BaseView> implements Presenter<V> {

    private V view;

    @Override
    public void bindView(V view) {
        this.view = view;
    }

    @Override
    public void unbindView() {
        view = null;
    }

    public boolean isViewBound() {
        return view != null;
    }

    public V getView() {
        return view;
    }

}
