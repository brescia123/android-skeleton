package com.cefriel.salmoiraghi150.ui.base;

public interface Presenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
