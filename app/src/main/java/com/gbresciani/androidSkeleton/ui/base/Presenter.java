package com.gbresciani.androidSkeleton.ui.base;

/**
 * Base Interface for all the presenters.
 *
 * @param <V> The type of view (which extends BaseView) the presenter is controlling.
 */
public interface Presenter<V extends BaseView> {

    /**
     * This method is called every time a view is bound to the presenter (e.g. configuration changes)
     * or it is re-created.
     * Implementing it allows the presenter to reset the view to the current "state" (e.g. one
     * network call is still alive and so the View has to display a ProgressBar).
     *
     * @param view the view to be bound
     */
    void bindView(V view);

    /**
     * Called when the view is destroyed and the presenter is no more needed.
     */
    void unbindView();
}
