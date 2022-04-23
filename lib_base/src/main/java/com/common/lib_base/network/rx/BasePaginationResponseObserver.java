package com.common.lib_base.network.rx;



import com.common.lib_base.base.BasicResponseRowsEntity;
import com.common.lib_base.controller.views.core.BaseBaseBaseIPaginationView;
import com.common.lib_base.network.core.BaseRequestPresenter;
import java.util.List;

public class BasePaginationResponseObserver<T> extends
        BaseResponseRowsObserver<BasicResponseRowsEntity<T>> {

    private final int mPage;

    private final BaseBaseBaseIPaginationView mView;

    public BasePaginationResponseObserver(BaseRequestPresenter presenter, BaseBaseBaseIPaginationView view, int page) {
        super(presenter, view, null);
        this.mPage = page;
        this.mView = view;
    }


    @Override
    public void onNext(BasicResponseRowsEntity<T> entity) {
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
