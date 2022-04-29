package com.common.myapplication.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.common.lib_base.base_view_vb.BaseVBActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.UseBaseVbActivityBinding;

public class UseBaseVBActivity extends BaseVBActivity<UseBaseVbActivityBinding> {



    @Override
    protected void initialize(Bundle savedInstanceState) {
        getBinding().tvUseBaseVb.setText("上天了");
    }
}
