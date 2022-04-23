package com.common.lib_base.network.observer;

import androidx.core.util.Consumer;
import com.common.lib_base.base_view.BaseResEntity;
import com.common.lib_base.network.exceptions.ExceptionHandler;
import com.common.lib_base.network.views.BaseIStatusView;
import com.common.lib_base.network.presenter.BaseRequestPresenter;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.net.ConnectException;

public class BaseResponseObserver<T extends BaseResEntity> implements Observer<T> {

    private BaseIStatusView view;

    private final Consumer<T> consume;

    private final BaseRequestPresenter persenter;

    private int SUCCESS_CODE = 200;

    private boolean needAllData;

    public void setNeedAllData(boolean needAllData) {
        this.needAllData = needAllData;
    }

    public void setSUCCESS_CODE(int SUCCESS_CODE) {
        this.SUCCESS_CODE = SUCCESS_CODE;
    }

    public BaseResponseObserver(BaseRequestPresenter presenter, BaseIStatusView view,
            Consumer<T> consumer) {
        this.view = view;
        this.consume = consumer;
        this.persenter = presenter;
    }


    @Override
    public void onSubscribe(Disposable d) {
        this.persenter.add(d);
    }


    @Override
    public void onNext(T t) {

        if (needAllData) {
            try {
                consume.accept(t);
                if (view != null) {
                    view.complete();
                }
            } catch (Exception e) {
                onError(e);
            }
            return;
        }

        if (t.getCode() == SUCCESS_CODE) {
            try {
                consume.accept(t);
                if (view != null) {
                    view.complete();
                }
            } catch (Exception e) {
                onError(e);
            }

        } else {
            Exception exception = new Exception(t.getMsg());
            onError(exception);
        }


    }


    @Override
    public void onError(Throwable e) {
        if (view != null) {

            if (e instanceof ConnectException) {
                view.offline();
            } else {
                view.failure(ExceptionHandler.handleException(e));
            }
        }

    }

    @Override
    public void onComplete() {

    }


}
