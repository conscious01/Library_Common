package com.common.lib_base.base_view;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.LayoutRes;


import com.common.lib_base.multiple_state.OnStateLayoutClickListener;
import com.common.lib_base.multiple_state.StateLayout;
import com.common.lib_base.network.views.BaseIStatusView;
import com.common.lib_base.network.views.BaseMultipleStateView;
import com.example.lib_base.R;
import com.jaeger.library.StatusBarUtil;

public abstract class BaseRequestActivity extends BaseActivity
        implements OnStateLayoutClickListener,
        BaseIStatusView {

    protected BaseIStatusView mStateView;
    protected StateLayout mStateLayout;
    protected View titleView;

    boolean useDefaultTitleLayout() {
        return true;
    }



    @Override
    public void setContentView(int layoutResID) {
        int titleLayoutRes;
        if (useDefaultTitleLayout()) {
            titleLayoutRes = R.layout.include_activity_title;
        } else {
            titleLayoutRes = getTitleLayoutRes();
        }
        // 创建状态布局, 添加标题

        if (titleLayoutRes != 0) {
            LinearLayout rootView = new LinearLayout(this);
            rootView.setLayoutParams(
                    new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                            FrameLayout.LayoutParams.MATCH_PARENT));
            rootView.setOrientation(LinearLayout.VERTICAL);
            titleView = LayoutInflater.from(this).inflate(titleLayoutRes, rootView, false);
            // 添加标题
            rootView.addView(titleView);

            // 添加状态布局
            mStateLayout = new StateLayout(this);
            mStateLayout.setLayoutParams(
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT));
            rootView.addView(mStateLayout);

            // 添加内容布局
            mStateLayout
                    .addView(LayoutInflater.from(this).inflate(layoutResID, mStateLayout, false));
            super.setContentView(rootView);

            // 重新请求网络监听
            mStateLayout.setOnAnewRequestNetworkListener(this);

        } else {
            super.setContentView(layoutResID);
        }

        mStateView = createStatusView();
    }

    @Override
    public void loading() {
        mStateView.loading();
    }

    @Override
    public void offline(boolean showErrorMsg) {
        mStateView.offline(showErrorMsg);
    }

    @Override
    public void failure(Throwable throwable,boolean showErrorMsg) {
        mStateView.failure(throwable,showErrorMsg);
    }


    @Override
    public void complete() {
        mStateView.complete();
    }

    @Override
    public void empty(CharSequence charSequence) {
        mStateView.empty(charSequence);
    }

    /**
     * 状态布局
     */
    protected BaseIStatusView createStatusView() {
        return new BaseMultipleStateView(this.mStateLayout);
    }

    @Override
    public void onRetry() {
        //mPresenter.anewRequest();
    }

    /**
     * 标题栏
     */
    protected @LayoutRes
    int getTitleLayoutRes() {
        return 0;
    }

}
