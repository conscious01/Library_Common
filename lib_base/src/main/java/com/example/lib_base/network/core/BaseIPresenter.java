package com.example.lib_base.network.core;


import com.example.lib_base.controller.views.core.BaseIView;

/**
 * base presenter
 */
public interface BaseIPresenter<V extends BaseIView> {

    /**
     * 绑定view
     */
    void setModelAndView(V view);

}
