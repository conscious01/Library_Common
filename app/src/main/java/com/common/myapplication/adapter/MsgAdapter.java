package com.common.myapplication.adapter;

import androidx.annotation.NonNull;
import com.blankj.utilcode.util.TimeUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.common.myapplication.bean.EntityMsg;
import com.example.myapplication.R;

/**
 * 消息列表适配器
 */
public class MsgAdapter extends BaseQuickAdapter<EntityMsg, BaseViewHolder> {

    public MsgAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, EntityMsg item) {

        helper.setVisible(R.id.item_iv_new_msg, item.getStatus() == 0);
        helper.setText(R.id.item_tv_title, item.getTitle());
        helper.setText(R.id.item_tv_intro, item.getIntro());
        helper.setText(R.id.item_tv_content, item.getContent());

        helper.setText(R.id.item_tv_time, TimeUtils.millis2String(item.getCreateDate()));

    }
}
