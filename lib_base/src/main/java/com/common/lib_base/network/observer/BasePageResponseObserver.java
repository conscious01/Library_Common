package com.common.lib_base.network.observer;



import com.common.lib_base.base_view.BaseResListEntity;
import com.common.lib_base.network.views.BaseIPageView;
import com.common.lib_base.network.presenter.BaseRequestPresenter;
import java.util.List;

public class BasePageResponseObserver<T> extends
        BaseResListObserver<BaseResListEntity<T>> {

    private final int page;
    private final int pageSize;

    private final BaseIPageView view;

    public BasePageResponseObserver(BaseRequestPresenter presenter, BaseIPageView view, int page,int pageSize) {
        super(presenter, view, null);
        this.page = page;
        this.view = view;
        this.pageSize = pageSize;

    }


    @Override
    public void onNext(BaseResListEntity<T> entity) {
        super.onNext(entity);

        List<T> dataList = entity.getRows();

        if (page <= 1) {
            view.renderRefresh(dataList);

        } else {
            view.renderLoadMore(dataList);
        }

        if (!((page * pageSize) < entity.getTotal())) {
            view.renderNoMore();
        }

        view.complete();
    }

}
