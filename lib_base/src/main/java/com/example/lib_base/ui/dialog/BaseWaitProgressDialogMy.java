package com.example.lib_base.ui.dialog;

import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.lib_base.R;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.CenterPopupView;
import com.lxj.xpopup.enums.PopupAnimation;

public class BaseWaitProgressDialogMy extends CenterPopupView {


    private TextView messageTextView = null;

    /**
     * 需要现实的等待消息。
     */
    private String mstrMessage = "";

    public BaseWaitProgressDialogMy(@NonNull Context context) {
        super(context);

    }

    public BaseWaitProgressDialogMy(@NonNull Context context, String msg) {
        super(context);
        mstrMessage = msg;
    }


    public static void show(Context context, String msg) {
        new XPopup.Builder(context)
                .isDestroyOnDismiss(false)
                .hasStatusBar(false)
                .enableShowWhenAppBackground(false)
                .dismissOnBackPressed(false)
                .dismissOnTouchOutside(false)
                .popupAnimation(PopupAnimation.ScaleAlphaFromCenter)
                .asCustom(new BaseWaitProgressDialogMy(context, msg))
                .show();
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.wait_progress_dialog_my;
    }


    @Override
    protected void onCreate() {
        super.onCreate();
        messageTextView = findViewById(R.id.messageTextView);
        messageTextView.setText(mstrMessage);
        this.setClickable(false);

    }

    public void setMessage(String strMessage) {

        mstrMessage = strMessage;
        if (messageTextView == null) {
            return;
        }
        messageTextView.setText(mstrMessage);
    }

}
