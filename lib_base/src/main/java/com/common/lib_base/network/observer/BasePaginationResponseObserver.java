package com.common.lib_base.network.observer;



import com.common.lib_base.base_view.BaseResponseRowsEntity;
import com.common.lib_base.network.views.BaseIPaginationView;
import com.common.lib_base.network.presenter.BaseRequestPresenter;
import java.util.List;

public class BasePaginationResponseObserver<T> extends
        BaseResponseRowsObserver<BaseResponseRowsEntity<T>> {

    private final int mPage;

    private final BaseIPaginationView mView;

    public BasePaginationResponseObserver(BaseRequestPresenter presenter, BaseIPaginationView view, int page) {
        super(presenter, view, null);
        this.mPage = page;
        this.mView = view;
    }


    @Override
    public void onNext(BaseResponseRowsEntity<T> entity) {
        super.onNext(entity);

        List<T> dataList = entity.getRows();

        if (mPage <= 1) {
            mView.renderRefresh(dataList);

        } else {
            mView.renderLoadMore(dataList);
        }

        if (!entity.hasMore()) {
            mView.renderNoMore();
        }

        mView.complete();
    }

}
