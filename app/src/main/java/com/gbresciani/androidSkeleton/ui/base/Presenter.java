package com.gbresciani.androidSkeleton.ui.base;

/**
 * Base Interface for all the presenters.
 *
 * @param <V> The type of view (which extends BaseView) the presenter is controlling.
 */
public interface Presenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
