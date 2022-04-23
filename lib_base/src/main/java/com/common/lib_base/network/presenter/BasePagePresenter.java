package com.common.lib_base.network.presenter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;


import com.common.lib_base.base_view.BaseResListEntity;
import com.common.lib_base.network.views.BaseIPageView;
import com.common.lib_base.network.observer.BasePageResponseObserver;
import com.common.lib_base.network.observer.BaseSchedulersTransformer;
import io.reactivex.Observable;

/**
 * 分页数据 帮助对象
 */
public abstract class BasePagePresenter<T> extends
        BaseRequestPresenter<BaseIPageView<T>> implements
        BaseIPagePresenter<BaseIPageView<T>, T> {

    protected int mPage,mPageSize=10;

    @Override
    public void setModelAndView(BaseIPageView<T> view) {
        super.setModelAndView(view);
    }

    @Override
    public void setPaginationView(BaseIPageView<T> view) {
        // 占位
    }



    @Override
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void requestRefresh() {
        mPage = 1;

        execute().compose(BaseSchedulersTransformer.transformer(mView))
                .subscribe(new BasePageResponseObserver<>(this, mView, mPage));
    }



    @Override
    public void requestLoadMore() {
        ++mPage;

        execute().compose(BaseSchedulersTransformer.transformer(mView))
                .subscribe(new BasePageResponseObserver<>(this, mView, mPage));
    }

    public void resetPage() {
        this.mPage = 1;
    }

    @Override
    public void anewRequest() {
        requestRefresh();
    }

    protected abstract Observable<BaseResListEntity<T>> execute();




}
