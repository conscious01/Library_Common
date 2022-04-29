package com.common.myapplication.ui.activity;

import android.os.Bundle;

import com.blankj.utilcode.util.LogUtils;
import com.common.lib_base.base_view.BaseActivity;
import com.example.myapplication.R;
import com.hjq.shape.view.ShapeButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UseButterKnifeActivity extends BaseActivity {
    @BindView(R.id.btn_)
    ShapeButton btn;


    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_use_butter_knife;
    }

    @Override
    protected void initialize(Bundle savedInstanceState) {
        btn.setText("我改变了");
    }

    @OnClick(R.id.btn_)
    public void onClick() {
        LogUtils.i("----");
    }
}
