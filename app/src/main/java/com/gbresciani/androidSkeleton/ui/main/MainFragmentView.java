package com.gbresciani.androidSkeleton.ui.main;

import com.gbresciani.androidSkeleton.ui.base.BaseView;

public interface MainFragmentView extends BaseView {

    void showProgress(boolean show);

    void showText(String text);
}
