package com.gbresciani.androidSkeleton.ui.base;


/**
 * Base Interface for all the components (Activities, Fragments) that acts as views in MVP.
 */
public interface BaseView {
    /**
     * This method has to be used to setup the presenters component to inject presenters. It helps
     * as a reminder for injecting the presenter to all the views that implement @BaseView
     */
    void setupPresentersComponent();
}
