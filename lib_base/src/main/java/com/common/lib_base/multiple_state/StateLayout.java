package com.common.lib_base.multiple_state;


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.example.lib_base.R;

public class StateLayout extends FrameLayout {

    public static final Integer FAILURE_STATE = 1;
    public static final Integer OFFLINE_STATE = 2;
    public static final Integer LOADING_STATE = 3;
    public static final Integer EMPTY_STATE   = 4;

    private int mDisplayStateLayoutCount; // 显示的状态布局数量

    private SparseArray<StateView> mStateArray = new SparseArray<>();


    public StateLayout(Context context) {
        this(context, null);
    }

    public StateLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.StateLayout);

        // 无网络
        addStateView(new OfflineStateView(ta.getResourceId(R.styleable.StateLayout_offline_res,
                R.layout.view_state_layout_offline)));

        // 网络加载中
        addStateView(new LoadingStateView(ta.getResourceId(R.styleable.StateLayout_loading_res,
                R.layout.view_state_layout_loading)));

        // 空状态
        addStateView(new EmptyStateView(ta.getResourceId(R.styleable.StateLayout_empty_res,
                R.layout.view_state_layout_empty)));

        // 错误
        addStateView(new FailureStateView(ta.getResourceId(R.styleable.StateLayout_failure_res,
                R.layout.view_state_layout_failure)));

        ta.recycle();
    }

    public StateLayout addStateView(StateView stateView) {
        mStateArray.put(stateView.getStateCode(), stateView);
        return this;
    }

    public void showContentView() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setVisibility(i < childCount - mDisplayStateLayoutCount ? View.VISIBLE : View.GONE);
        }
    }

    public void showStateView(int stateCode) {
        this.showStateView(stateCode, null);
    }

    public void showStateView(int stateCode, CharSequence charSequence) {
        StateView stateView = mStateArray.get(stateCode);

        if (stateView == null) {
            throw new IllegalStateException("没有这个状态布局，code:" + stateCode);
        }

        if (stateView.getStateView() == null) {
            ++mDisplayStateLayoutCount;
            stateView.bindParentView(this);
        }

        for (int i = 0; i < mStateArray.size(); i++) {
            StateView view = mStateArray.get(mStateArray.keyAt(i));
            if (view.getStateView() != null) {
                view.display(charSequence, view == stateView);
                view.getStateView().setVisibility(view == stateView ? VISIBLE : GONE);
            }
        }
    }

    public void setOnAnewRequestNetworkListener(
            OnStateLayoutClickListener onStateLayoutClickListener) {
        for (int i = 0; i < mStateArray.size(); i++) {
            StateView stateView = mStateArray.get(mStateArray.keyAt(i));
            stateView.setOnAnewRequestNetworkListener(onStateLayoutClickListener);
        }
    }


    public interface StateView {

        Integer getStateCode();

        View getStateView();

        void bindParentView(StateLayout parentView);

        void display(CharSequence message, boolean visibility);

        void setOnAnewRequestNetworkListener(
                OnStateLayoutClickListener onStateLayoutClickListener);
    }

}
