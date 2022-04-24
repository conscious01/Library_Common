package com.common.lib_base.network.views;



import android.content.Context;
import com.blankj.utilcode.util.ToastUtils;
import com.common.lib_base.network.exceptions.ExceptionHandler;
import com.common.lib_base.network.exceptions.ExceptionHandler.ResponeThrowable;
import com.example.lib_base.R;
import com.common.lib_base.common.utils.BaseUniversalToast;

/**
 * 网络请求中的提示信息
 */
public class BaseToastRequestStatusView implements BaseIStatusView {

    private final Context context;

    public BaseToastRequestStatusView(Context context) {
        this.context = context;
    }

    @Override
    public void loading() {

    }


    @Override
    public void failure(Throwable throwable,boolean showErrorMsg) {
        throwable.printStackTrace();

        if (throwable != null && showErrorMsg) {
            ResponeThrowable responeThrowable = ExceptionHandler.handleException(throwable);
            String errorMsg = responeThrowable.code + " " + responeThrowable.message;
            BaseUniversalToast.showFailedIconToast(errorMsg);
        }

    }

    @Override
    public void offline(boolean showErrorMsg) {
        if (showErrorMsg) {
            ToastUtils.showShort(context.getString(R.string.tv_net_tips_1));
        }
    }

}
