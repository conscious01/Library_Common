package com.example.myapplication;

import androidx.annotation.NonNull;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

/**
 * @author Mr.W
 * @since 11/3/2022 4:05 pm
 */
public class AdapterDemo extends BaseQuickAdapter<String, BaseViewHolder> {

    public AdapterDemo(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.item_tv, s);
    }
}
