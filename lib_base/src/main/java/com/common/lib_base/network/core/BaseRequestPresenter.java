package com.common.lib_base.network.core;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;


import com.common.lib_base.controller.views.core.BaseBaseIStatusView;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 请求
 */
public abstract class BaseRequestPresenter<V extends BaseBaseIStatusView> implements LifecycleObserver,
        BaseIPresenter<V> {

    protected V mView;

    private final CompositeDisposable mCompositeDisposable;

    public BaseRequestPresenter() {
        this.mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void setModelAndView(V view) {
        this.mView = view;
    }

    // fragment
    public void onHiddenChanged(boolean hidden){

    }

    public void add(@NonNull Disposable d){
        mCompositeDisposable.add(d);
    }

    /**
     * 重新进行请求
     */
    public void anewRequest(){

    }

    /**
     * 清除所有订阅
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void clear() {
        mCompositeDisposable.clear();
    }

}
