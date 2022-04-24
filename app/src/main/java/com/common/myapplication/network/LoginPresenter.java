package com.common.myapplication.network;

import com.common.lib_base.base_view.BaseResEntity;
import com.common.lib_base.network.observer.BaseResponseObserver;
import com.common.lib_base.network.observer.BaseSchedulersTransformer;
import com.common.lib_base.network.observer.BaseSchedulersTransformer2;
import com.common.lib_base.network.presenter.BaseRequestPresenter;
import com.common.lib_base.network.views.BaseIStatusView;
import com.common.myapplication.core.BaseRetrofitManger;

public class LoginPresenter extends BaseRequestPresenter<LoginPresenter.View> {


    public void doLogin(String name, String password) {

        BaseResponseObserver observer =
                new BaseResponseObserver<>(this, mView, entity -> mView.onLoginSuccess(entity));

        observer.setNeedAllData(true);
        observer.setShowErrorMsg(false);
        BaseRetrofitManger.getInstance().doLogin(name, password)
                .compose(BaseSchedulersTransformer2.transformer(mView))
                .subscribe(observer);

    }

    public interface View extends BaseIStatusView {

        void onLoginSuccess(BaseResEntity loginResult);

    }

}
