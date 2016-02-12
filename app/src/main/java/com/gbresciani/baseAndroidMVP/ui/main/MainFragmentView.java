package com.gbresciani.baseAndroidMVP.ui.main;

import com.gbresciani.baseAndroidMVP.ui.base.BaseView;

public interface MainFragmentView extends BaseView {

    void showProgress(boolean show);

    void showText(String text);
}
