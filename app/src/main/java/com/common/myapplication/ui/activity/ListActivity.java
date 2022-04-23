package com.common.myapplication.ui.activity;

import android.os.Bundle;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.common.lib_base.base_view.BaseListRequestActivity;
import com.common.lib_base.common.utils.ViewUtils;
import com.common.lib_base.network.presenter.BasePagePresenter;
import com.common.myapplication.adapter.MsgAdapter;
import com.common.myapplication.network.MsgListPresenter;
import com.example.myapplication.R;

public class ListActivity extends BaseListRequestActivity {

    @Override
    protected int getTitleRes() {
        return R.string.app_info_tip;
    }

    @Override
    protected BaseQuickAdapter getAdapter() {
        return new MsgAdapter(R.layout.rv_item_msg);
    }

    @Override
    protected BasePagePresenter getPresenter() {
        return new MsgListPresenter("");
    }

    @Override
    protected void initRecyclerView() {
        recyclerView.setLayoutManager(ViewUtils.getRVVerticalLayoutManager(this));
        recyclerView.addItemDecoration(ViewUtils.getRVVerticalDivider(this));
    }


}
