package com.common.lib_base.network.presenter;


import com.common.lib_base.network.views.BaseIView;

/**
 * base presenter
 */
public interface BaseIPresenter<V extends BaseIView> {

    /**
     * 绑定view
     */
    void setModelAndView(V view);

}
