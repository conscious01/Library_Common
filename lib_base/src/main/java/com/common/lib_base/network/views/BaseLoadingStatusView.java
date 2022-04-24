package com.common.lib_base.network.views;

import android.content.Context;
import com.example.lib_base.R;
import com.common.lib_base.ui.dialog.BaseWaitProgressDialogMy;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;

/**
 * 网络请求中的弹窗
 */
public class BaseLoadingStatusView implements BaseIStatusView {

    private Context context;
    private String msg;

    private BasePopupView mLoading;

    private BaseIStatusView mToastStatusView;

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
        showLoading();
    }

    @Override
    public void offline(boolean showErrorMsg) {
        dismiss();
        mToastStatusView.offline(showErrorMsg);
    }

    @Override
    public void failure(Throwable throwable,boolean showErrorMsg) {
        dismiss();
        mToastStatusView.failure(throwable,showErrorMsg);
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
