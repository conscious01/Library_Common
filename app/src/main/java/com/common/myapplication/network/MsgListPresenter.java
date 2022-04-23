package com.common.myapplication.network;


import com.common.lib_base.base_view.BaseResListEntity;
import com.common.lib_base.network.presenter.BasePagePresenter;
import com.common.myapplication.bean.EntityMsg;
import com.common.myapplication.core.BaseRetrofitManger;
import io.reactivex.Observable;

public class MsgListPresenter extends BasePagePresenter {

    private final String msgId;

    public MsgListPresenter(String mFilterId) {
        this.msgId = mFilterId;
    }

    @Override
    protected Observable<BaseResListEntity<EntityMsg>> execute() {

        return BaseRetrofitManger.getInstance().getMsgList(page, msgId);

    }
}
