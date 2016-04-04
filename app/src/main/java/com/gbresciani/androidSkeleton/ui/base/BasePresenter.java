package com.gbresciani.androidSkeleton.ui.base;

import java.lang.ref.WeakReference;

import timber.log.Timber;

/**
 * Base Class for all the presenters. It takes care of implementing the bind/unbind view mechanism.
 *
 * @param <V> The type of view the presenter is controlling.
 */
public abstract class BasePresenter<V extends BaseView> implements Presenter<V> {

    private WeakReference<V> view;

    @Override
    public void bindView(V view) {
        Timber.i("%s -> bindView", getClass().getSimpleName());
        this.view = new WeakReference<>(view);
    }

    @Override
    public void unbindView() {
        Timber.i("%s -> unbindView", getClass().getSimpleName());
        view = null;
    }

    @Override
    public void destroyView() {
        Timber.i("%s -> destroyView", getClass().getSimpleName());
        view = null;
    }

    public boolean isViewBound() {
        return view != null;
    }

    public V getView() {
        return view.get();
    }

}
