package com.common.lib_base.network.observer;

import androidx.core.util.Consumer;

import com.blankj.utilcode.util.LogUtils;

import com.common.lib_base.base_view.BaseResListEntity;
import com.common.lib_base.network.exceptions.ExceptionHandler;
import com.common.lib_base.network.views.BaseIStatusView;
import com.common.lib_base.network.presenter.BaseRequestPresenter;

import java.net.ConnectException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class BaseResListObserver<T extends BaseResListEntity> implements Observer<T> {

    private BaseIStatusView mView;

    private final Consumer<T> mConsumer;

    private final BaseRequestPresenter mPresenter;


    public BaseResListObserver(BaseRequestPresenter presenter, BaseIStatusView view,
            Consumer<T> consumer) {
        this.mView = view;
        this.mConsumer = consumer;
        this.mPresenter = presenter;
    }


    @Override
    public void onSubscribe(Disposable d) {
        this.mPresenter.add(d);
    }


    @Override
    public void onNext(T t) {
        //todo
        if (t.getCode() != 200) { // 失败

            Exception exception;

            exception = new Exception(t.getMsg());

            onError(exception);

        } else if (mConsumer != null) { // 成功

            try {

                mConsumer.accept(t);

                if (mView != null) {
                    mView.complete();
                }

            } catch (Exception e) {

                onError(e);
            }

        }

    }


    @Override
    public void onError(Throwable e) {
        LogUtils.e(e);
        if (mView != null) {

            if (e instanceof ConnectException) {
                mView.offline();
            } else {
                mView.failure(e);

            }
        }

    }


    @Override
    public void onComplete() {

    }

}
