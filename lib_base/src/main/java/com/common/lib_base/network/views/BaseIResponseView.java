package com.common.lib_base.network.views;


import com.common.lib_base.base_view.BaseResponseEntity;
import com.common.lib_base.base_view.BaseResponseRowsEntity;

public interface BaseIResponseView extends BaseIStatusView {

    /**
     * @param responseEntity 使用示例，参考 RechargeCouponActivity 中的 PaymentPresenter
     */
    void onResponseData(BaseResponseEntity responseEntity);

    void onResponseData(BaseResponseRowsEntity responseEntity);

}
