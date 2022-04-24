package com.common.myapplication.ui.activity;

import android.os.Bundle;
import com.blankj.utilcode.util.LogUtils;
import com.common.lib_base.base_view.BaseActivity;
import com.common.lib_base.base_view.BaseRequestActivity;
import com.common.lib_base.common.utils.ViewUtils;
import com.example.myapplication.R;
import com.jaeger.library.StatusBarUtil;

public class StatusBarActivity extends BaseRequestActivity {

    private com.hjq.shape.view.ShapeButton btn1;
    private com.hjq.shape.view.ShapeButton btn2;
    private com.hjq.shape.view.ShapeButton btn3;
    private com.hjq.shape.view.ShapeButton btn4;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_status_bar;
    }

    @Override
    protected void initialize(Bundle savedInstanceState) {
        initView();
        btn1.setOnClickListener(v -> {
            StatusBarUtil.setTransparent(this);

        });
        btn2.setOnClickListener(v -> {

            if (ViewUtils.ifFastClick()) {
                LogUtils.i("快速点击不处理");
            }else {
                LogUtils.i("btn2我被电击了");

            }


//            StatusBarUtil.setTranslucent(this);
        });
        btn3.setOnClickListener(v -> {
            if (ViewUtils.ifFastClick()) {
                LogUtils.i("快速点击不处理");
            }else {
                LogUtils.i("btn3我被电击了");

            }

//            StatusBarUtil.setTransparentForImageView(this,null);
        });
        btn4.setOnClickListener(v -> {
            StatusBarUtil.setTransparentForImageView(this,null);

        });
    }

    private void initView() {
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
    }
}
