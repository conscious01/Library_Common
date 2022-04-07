package com.example.lib_base.network.core;



import com.example.lib_base.base.BasicResponseRowsEntity;
import com.example.lib_base.controller.views.core.BaseBaseBaseIPaginationView;
import com.example.lib_base.network.rx.BasePaginationResponseObserver;
import com.example.lib_base.network.rx.BaseSchedulersTransformer;
import io.reactivex.Observable;

/**
 * 分页数据 帮助对象 手动调用请求，不跟随OnLifecycle
 */
public abstract class BaseSimplePaginationPresenterManual<T> extends
        BaseRequestPresenter<BaseBaseBaseIPaginationView<T>> implements
        BaseIPaginationPresenter<BaseBaseBaseIPaginationView<T>, T> {

    protected int mPage,mPageSize=10;

    @Override
    public void setModelAndView(BaseBaseBaseIPaginationView<T> view) {
        super.setModelAndView(view);
    }

    @Override
    public void setPaginationView(BaseBaseBaseIPaginationView<T> view) {
        // 占位
    }

    @Override
    public void requestRefresh() {
        mPage = 1;

        execute().compose(BaseSchedulersTransformer.transformer(mView))
                .subscribe(new BasePaginationResponseObserver<>(this, mView, mPage));
    }

    @Override
    public void requestLoadMore() {
        ++mPage;

        execute().compose(BaseSchedulersTransformer.transformer(mView))
                .subscribe(new BasePaginationResponseObserver<>(this, mView, mPage));
    }

    public void resetPage() {
        this.mPage = 1;
    }

    @Override
    public void anewRequest() {
        requestRefresh();
    }

    protected abstract Observable<BasicResponseRowsEntity<T>> execute();

}
