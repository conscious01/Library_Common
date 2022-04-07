package com.example.lib_base.moddule;

/**
 * @author Mr.W
 * @since 11/3/2022 10:30 pm
 */
public class EntityBaseDialog {

    String title;
    String content;
    String confirmText;

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
