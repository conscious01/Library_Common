package com.common.lib_base.controller.views.impl;

import android.content.Context;
import com.example.lib_base.R;
import com.common.lib_base.controller.views.core.BaseBaseIStatusView;
import com.common.lib_base.ui.dialog.BaseWaitProgressDialogMy;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;

/**
 * 网络请求中的弹窗
 */
public class BaseLoadingStatusView implements BaseBaseIStatusView {

    private Context context;
    private String msg;

    private BasePopupView mLoading;

    private BaseBaseIStatusView mToastStatusView;

    public BaseLoadingStatusView(Context context) {
        this(context, "请求中...");
        mToastStatusView = new BaseToastRequestStatusView(context);
    }

    public BaseLoadingStatusView(Context context, String message) {
        this.context = context;
        this.msg = message;
        mToastStatusView = new BaseToastRequestStatusView(context);

    }

    @Override
    public void loading() {
        if (mLoading == null) {
            mLoading = new XPopup.Builder(context)
                    .dismissOnTouchOutside(false)
                    .hasStatusBar(false)
                    .dismissOnBackPressed(false)
                    .asCustom(new BaseWaitProgressDialogMy(context, msg))
                    .show();

        } else {

            mLoading.show();
        }
    }

    @Override
    public void offline() {
        dismiss();
        mToastStatusView.offline();
    }

    @Override
    public void failure(Throwable throwable) {
        dismiss();
        mToastStatusView.failure(throwable);
    }

    @Override
    public void failureWithMethodName(Throwable throwable, String methodName) {
        dismiss();
        mToastStatusView.failureWithMethodName(throwable, methodName);
    }

    @Override
    public void complete() {
        dismiss();
    }

    public void dismiss() {
        if (mLoading != null) {
            mLoading.dismiss();
        }
    }

    public void showLoading() {
        if (mLoading == null) {
            mLoading = new XPopup.Builder(context)
                    .dismissOnTouchOutside(false)
                    .hasStatusBar(false)
                    .dismissOnBackPressed(false)
                    .asLoading(context.getString(R.string.loading))
                    .show();
        } else {

            mLoading.show();
        }
    }


}
