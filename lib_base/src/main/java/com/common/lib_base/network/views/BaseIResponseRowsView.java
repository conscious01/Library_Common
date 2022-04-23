package com.common.lib_base.network.views;


import com.common.lib_base.base_view.BaseResponseRowsEntity;

public interface BaseIResponseRowsView extends BaseIStatusView {

    /**
     * @param responseEntity 使用示例，参考 RechargeCouponActivity 中的 PaymentPresenter
     */
    void onResponseData(BaseResponseRowsEntity responseEntity);
}
