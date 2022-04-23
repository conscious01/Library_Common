package com.common.lib_base.controller.views.impl;



import android.content.Context;
import com.blankj.utilcode.util.ToastUtils;
import com.common.lib_base.controller.views.core.BaseBaseIStatusView;
import com.example.lib_base.R;
import com.common.lib_base.common.utils.UniversalToastUtil;

/**
 * 网络请求中的提示信息
 */
public class BaseToastRequestStatusView implements BaseBaseIStatusView {

    private final Context context;

    public BaseToastRequestStatusView(Context context) {
        this.context = context;
    }

    @Override
    public void loading() {

    }

    @Override
    public void failureWithMethodName(Throwable throwable, String methodName) {

    }

    @Override
    public void failure(Throwable throwable) {
        throwable.printStackTrace();

        if (throwable != null) {
            UniversalToastUtil.showFailedIconToast(throwable.getMessage());
        }

    }

    @Override
    public void offline() {
        ToastUtils.showShort(context.getString(R.string.network_error));
    }

}
