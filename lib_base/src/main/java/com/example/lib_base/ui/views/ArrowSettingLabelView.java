package com.example.lib_base.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.lib_base.R;


/**
 * 带箭头的标签
 */
public class ArrowSettingLabelView extends ConstraintLayout {

    private TextView tvLabel;
    private View dividingView;
    private TextView tv_label_second;

    public ArrowSettingLabelView(@NonNull Context context) {
        super(context);
    }

    public ArrowSettingLabelView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initViews(context);

        TypedArray attributes = context
                .obtainStyledAttributes(attrs, R.styleable.ArrowSettingLabelView);
        String text = attributes.getString(R.styleable.ArrowSettingLabelView_label_arrow_text);

        boolean ifShowDividing = attributes
                .getBoolean(R.styleable.ArrowSettingLabelView_label_arrow_dividing_line, false);
        tvLabel.setText(text);
        if (ifShowDividing) {
            dividingView.setVisibility(View.VISIBLE);
        }


    }


    private void initViews(Context context) {
        View root = View.inflate(context, R.layout.c_arrow_setting_label, this);
        tvLabel = root.findViewById(R.id.tv_label);
        tv_label_second = root.findViewById(R.id.tv_label_second);
        dividingView = root.findViewById(R.id.label_dividing_view);

    }

    /**
     * 设置右边文字
     *
     * @param text 字符串
     */
    public void setRightTv(String text) {
        if (!TextUtils.isEmpty(text)) {
            tv_label_second.setText(text);
        }
    }

    public String getRightTVString() {
        return tv_label_second.getText().toString();
    }
}
