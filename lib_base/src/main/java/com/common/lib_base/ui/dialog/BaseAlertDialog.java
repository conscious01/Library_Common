package com.common.lib_base.ui.dialog;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.lib_base.R;
import com.common.lib_base.module.EntityBaseDialog;
import com.lxj.xpopup.core.CenterPopupView;

/**
 * 类名: AlertDialog
 * 功能: 用于提示对话框。
 */
public class BaseAlertDialog extends CenterPopupView {


    private OnBtnClick onConfirmClick = null;

    private OnBtnClick onCancelBtnClick = null;



    private TextView tvTitle,tvContent;
    private Button btnConfirm,btnCancel;
    private EntityBaseDialog entityBaseDialog;
    private Activity activity;

    public BaseAlertDialog(@NonNull Context context) {
        super(context);
    }

    public BaseAlertDialog(@NonNull Context context, EntityBaseDialog entityBaseDialog) {
        super(context);
        this.entityBaseDialog = entityBaseDialog;
        this.activity = (Activity) context;
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.alert_dialog;
    }

    @Override
    protected void onCreate() {
        super.onCreate();

        tvTitle = findViewById(R.id.tv_title);
        tvContent = findViewById(R.id.tv_content);
        btnConfirm = findViewById(R.id.btn_confirm);
        btnCancel = findViewById(R.id.btn_cancel);



        this.tvTitle.setText(entityBaseDialog.getTitle());

        this.tvContent.setText(Html.fromHtml( entityBaseDialog.getContent()));
        this.tvContent.setMovementMethod(ScrollingMovementMethod.getInstance());

        if (!TextUtils.isEmpty(entityBaseDialog.getCancelText())) {
            btnCancel.setText(entityBaseDialog.getCancelText());
        }

        if (entityBaseDialog.isIfShowCancel()) {
            btnCancel.setVisibility(View.VISIBLE);
        } else {
            btnCancel.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(entityBaseDialog.getConfirmText())) {
            btnConfirm.setText(entityBaseDialog.getConfirmText());
        }
        installEvents();
        activity.getWindow().setWindowAnimations(R.style.dialog_anim1);
    }


    private void installEvents() {

        this.btnConfirm.setOnClickListener(v -> {

            if (BaseAlertDialog.this.onConfirmClick != null) {
                BaseAlertDialog.this.onConfirmClick.onClick();
            }
            BaseAlertDialog.this.dismiss();
        });

        this.btnCancel.setOnClickListener(v -> {

            if (BaseAlertDialog.this.onCancelBtnClick != null) {
                BaseAlertDialog.this.onCancelBtnClick.onClick();
            }
            BaseAlertDialog.this.dismiss();
        });
    }

    public void setOnConfirmClick(OnBtnClick onBtnClick) {
        this.onConfirmClick = onBtnClick;
    }

    public void setCancelBtnClick(OnBtnClick onBtnClick) {
        this.onCancelBtnClick = onBtnClick;
    }


    public interface OnBtnClick {
        void onClick();
    }


}
