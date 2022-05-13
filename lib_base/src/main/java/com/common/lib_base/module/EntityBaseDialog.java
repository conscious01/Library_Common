package com.common.lib_base.module;

import com.common.lib_base.ui.dialog.BaseAlertDialog.OnBtnClick;

/**
 * @author Mr.W
 * @since 11/3/2022 10:30 pm
 */
public class EntityBaseDialog {

    String title;
    String content;
    String confirmText;

    private OnBtnClick onConfirmClick ;

    private OnBtnClick onCancelBtnClick ;

    public OnBtnClick getOnConfirmClick() {
        return onConfirmClick;
    }

    public void setOnConfirmClick(OnBtnClick onConfirmClick) {
        this.onConfirmClick = onConfirmClick;
    }

    public OnBtnClick getOnCancelBtnClick() {
        return onCancelBtnClick;
    }

    public void setOnCancelBtnClick(
            OnBtnClick onCancelBtnClick) {
        this.onCancelBtnClick = onCancelBtnClick;
    }

    public String getConfirmText() {
        return confirmText;
    }

    public void setConfirmText(String confirmText) {
        this.confirmText = confirmText;
    }

    public String getCancelText() {
        return cancelText;
    }

    public void setCancelText(String cancelText) {
        this.cancelText = cancelText;
    }

    String cancelText;
    boolean ifShowCancel;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isIfShowCancel() {
        return ifShowCancel;
    }

    public void setIfShowCancel(boolean ifShowCancel) {
        this.ifShowCancel = ifShowCancel;
    }
}
