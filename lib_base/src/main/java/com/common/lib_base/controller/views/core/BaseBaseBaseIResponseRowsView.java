package com.common.lib_base.controller.views.core;


import com.common.lib_base.base.BasicResponseRowsEntity;

public interface BaseBaseBaseIResponseRowsView extends BaseBaseIStatusView {

    /**
     * @param responseEntity 使用示例，参考 RechargeCouponActivity 中的 PaymentPresenter
     */
    void onResponseData(BasicResponseRowsEntity responseEntity);
}