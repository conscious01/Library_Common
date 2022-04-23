package com.common.myapplication;

import android.content.Context;
import androidx.annotation.NonNull;
import com.example.myapplication.R;
import com.example.myapplication.databinding.DialogUseVbBinding;
import com.lxj.xpopup.core.CenterPopupView;

public class VBDialog extends CenterPopupView {

    public VBDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_use_vb;
    }

    private DialogUseVbBinding binding;

    @Override
    protected void onCreate() {
        super.onCreate();
        binding = DialogUseVbBinding.bind(getPopupImplView());
//        binding.tvInDialog.setText(" 使用viewbinding的弹窗 \n代码修改");

    }
}
