package com.example.myapplication;

import android.os.Bundle;
import com.example.lib_base.basewithvb.BaseVBActivity;
import com.example.myapplication.databinding.UseBaseVbActivityBinding;

public class UseBaseVBActivity extends BaseVBActivity<UseBaseVbActivityBinding> {

    @Override
    protected void initialize(Bundle savedInstanceState) {
        getBinding().tvUseBaseVb.setText("changed from outside");
    }
}
