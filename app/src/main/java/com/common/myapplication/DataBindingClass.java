package com.common.myapplication;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.example.myapplication.databinding.ActivityBindingBinding;

/**
 * @author Mr.W
 * @since 19/3/2022 3:36 pm
 */
public class DataBindingClass extends Activity {

    private ActivityBindingBinding bindingBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingBinding = ActivityBindingBinding.inflate(getLayoutInflater());
        setContentView(bindingBinding.getRoot());
        bindingBinding.tvBinding.setText("changed ");
    }


}
