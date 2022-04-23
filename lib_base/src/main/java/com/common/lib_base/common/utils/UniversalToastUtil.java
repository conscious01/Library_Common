package com.common.lib_base.common.utils;

import android.text.TextUtils;
import android.view.Gravity;

import androidx.core.content.ContextCompat;


import com.common.lib_base.BaseApplication;
import com.example.lib_base.R;
import xyz.bboylin.universialtoast.UniversalToast;


/**
 * 成功和失败的弹窗提示
 * @author Administrator
 */
public class UniversalToastUtil {

    public static void showToast(String message) {
        showToast(message, UniversalToast.LENGTH_SHORT);
    }

    public static void showToast(String message, int duration) {
        if (TextUtils.isEmpty(message)) {
            return;
        }
        UniversalToast.makeText(BaseApplication.getContext(),
                message,
                duration,
                UniversalToast.EMPHASIZE)
                .setGravity(Gravity.CENTER, 0, 0)
                .setBackground(ContextCompat.getDrawable(BaseApplication.getContext(), R.drawable.toast_bg))
                .show();
    }

    public static void showSucceedIconToast(String message) {
        UniversalToast.makeText(BaseApplication.getContext(),
                message,
                UniversalToast.LENGTH_SHORT,
                UniversalToast.EMPHASIZE)
                .setGravity(Gravity.CENTER, 0, 0)
                .setBackground(ContextCompat.getDrawable(BaseApplication.getContext(), R.drawable.toast_bg))
                .setIcon(R.drawable.toast_success)// 设置icon，未调用的话icon不可见(gone)
                .show();
    }

    public static void showFailedIconToast(String message) {
        UniversalToast.makeText(BaseApplication.getContext(),
                message,
                UniversalToast.LENGTH_LONG,
                UniversalToast.EMPHASIZE)
                .setGravity(Gravity.CENTER, 0, 0)
                .setBackground(ContextCompat.getDrawable(BaseApplication.getContext(), R.drawable.toast_bg))
                .setIcon(R.drawable.toast_failed)// 设置icon，未调用的话icon不可见(gone)
                .show();
    }

}
