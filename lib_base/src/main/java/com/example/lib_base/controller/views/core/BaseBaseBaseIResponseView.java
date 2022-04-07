package com.example.lib_base.controller.views.core;


import com.example.lib_base.base.BasicResponseEntity;
import com.example.lib_base.base.BasicResponseRowsEntity;

public interface BaseBaseBaseIResponseView extends BaseBaseIStatusView {

    /**
     * @param responseEntity 使用示例，参考 RechargeCouponActivity 中的 PaymentPresenter
     */
    void onResponseData(BasicResponseEntity responseEntity);

    void onResponseData(BasicResponseRowsEntity responseEntity);

}
