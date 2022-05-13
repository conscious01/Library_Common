package com.common.myapplication.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import com.common.lib_base.base_view.BaseActivity;
import com.common.lib_base.common.image.GlideApp;
import com.example.myapplication.R;
import xyz.bboylin.universialtoast.UniversalToast;

/**
 * @author Mr.W
 * @since 11/3/2022 4:20 pm
 */
public class ImageActivity extends BaseActivity {

    private ImageView iv1;



    @Override
    protected int getContentLayoutId() {
        return R.layout.iamge_activity;
    }

    @Override
    protected void initialize(Bundle savedInstanceState) {
        iv1 = findViewById(R.id.iv_1);
        GlideApp.with(this).load(R.mipmap.ic_launcher).into(iv1);
    }
}
