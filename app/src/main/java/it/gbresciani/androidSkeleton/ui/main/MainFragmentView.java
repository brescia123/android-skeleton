package it.gbresciani.androidSkeleton.ui.main;

import it.gbresciani.androidSkeleton.ui.base.BaseView;

public interface MainFragmentView extends BaseView {

    void showProgress(boolean show);

    void showText(String text);
}
