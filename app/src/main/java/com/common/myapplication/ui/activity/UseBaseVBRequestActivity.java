package com.common.myapplication.ui.activity;

import android.os.Bundle;
import com.common.lib_base.base_view_vb.BaseVBRequestActivity;
import com.common.lib_base.common.utils.ActivityTitleHelper;
import com.example.myapplication.databinding.ActivityUseBaseVbReqBinding;

public class UseBaseVBRequestActivity extends BaseVBRequestActivity<ActivityUseBaseVbReqBinding> {

    @Override
    protected void initialize(Bundle savedInstanceState) {
        ActivityTitleHelper.setTitle(this,"我是大标题");
        getBinding().tvUseBaseVbReq.setText("不要");

        offline(true);
    }
}
