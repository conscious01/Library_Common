package com.common.lib_base.network.presenter;



import com.common.lib_base.base_view.BaseResponseRowsEntity;
import com.common.lib_base.network.views.BaseIPaginationView;
import com.common.lib_base.network.observer.BasePaginationResponseObserver;
import com.common.lib_base.network.observer.BaseSchedulersTransformer;
import io.reactivex.Observable;

/**
 * 分页数据 帮助对象 手动调用请求，不跟随OnLifecycle
 */
public abstract class BaseSimplePaginationPresenterManual<T> extends
        BaseRequestPresenter<BaseIPaginationView<T>> implements
        BaseIPaginationPresenter<BaseIPaginationView<T>, T> {

    protected int mPage,mPageSize=10;

    @Override
    public void setModelAndView(BaseIPaginationView<T> view) {
        super.setModelAndView(view);
    }

    @Override
    public void setPaginationView(BaseIPaginationView<T> view) {
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

    protected abstract Observable<BaseResponseRowsEntity<T>> execute();

}
