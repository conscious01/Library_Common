package com.common.lib_base.network.observer;



import com.common.lib_base.base_view.BaseResListEntity;
import com.common.lib_base.network.views.BaseIPageView;
import com.common.lib_base.network.presenter.BaseRequestPresenter;
import java.util.List;

public class BasePageResponseObserver<T> extends
        BaseResListObserver<BaseResListEntity<T>> {

    private final int mPage;

    private final BaseIPageView mView;

    public BasePageResponseObserver(BaseRequestPresenter presenter, BaseIPageView view, int page) {
        super(presenter, view, null);
        this.mPage = page;
        this.mView = view;
    }


    @Override
    public void onNext(BaseResListEntity<T> entity) {
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
