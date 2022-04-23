package com.common.lib_base.network.core;


import com.common.lib_base.controller.views.core.BaseIView;

/**
 * base presenter
 */
public interface BaseIPresenter<V extends BaseIView> {

    /**
     * 绑定view
     */
    void setModelAndView(V view);

}
