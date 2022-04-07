package com.example.lib_base.network.rx;

import android.text.TextUtils;

import androidx.core.util.Consumer;

import com.blankj.utilcode.util.LogUtils;

import com.example.lib_base.base.BasicResponseRowsEntity;
import com.example.lib_base.controller.views.core.BaseBaseBaseIResponseView;
import com.example.lib_base.controller.views.core.BaseBaseIStatusView;
import com.example.lib_base.network.core.BaseRequestPresenter;
import com.mondo.logger.Logger;

import java.net.ConnectException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class BaseResponseRowsObserver<T extends BasicResponseRowsEntity> implements Observer<T> {

    private BaseBaseIStatusView mView;

    private final Consumer<T> mConsumer;

    private final BaseRequestPresenter mPresenter;

    private String mMethodName;


    /**
     * 不显示后台返回的msg，默认为false，即为展示，如需不展示，ResponseObserver构造方法里设置为true即可
     */
    private boolean mNotShowMsg;

    public BaseResponseRowsObserver(BaseRequestPresenter presenter, BaseBaseIStatusView view, Consumer<T> consumer) {
        this.mView = view;
        this.mConsumer = consumer;
        this.mPresenter = presenter;
    }


    public BaseResponseRowsObserver(BaseRequestPresenter presenter, BaseBaseIStatusView view, Consumer<T> consumer,
                                boolean notShowMsg) {
        this.mView = view;
        this.mConsumer = consumer;
        this.mPresenter = presenter;
        this.mNotShowMsg = notShowMsg;
    }

    public BaseResponseRowsObserver(BaseRequestPresenter presenter, BaseBaseBaseIResponseView view, Consumer<T> consumer) {
        this.mView = view;
        this.mConsumer = consumer;
        this.mPresenter = presenter;
    }

    public BaseResponseRowsObserver(BaseRequestPresenter presenter, BaseBaseBaseIResponseView view, Consumer<T> consumer, String methodName) {
        this.mView = view;
        this.mConsumer = consumer;
        this.mPresenter = presenter;
        this.mMethodName = methodName;
    }

    @Override
    public void onSubscribe(Disposable d) {
        this.mPresenter.add(d);
    }


    @Override
    public void onNext(T t) {

        if (t.getCode() != 200) { // 失败

            if (mView instanceof BaseBaseBaseIResponseView) { //如果是IResponseView，就返回给单独处理
                t.setMethodName(mMethodName);
                mConsumer.accept(t);
                mView.complete();
                mView = null;
                return;
            }

            Exception exception = null;

            exception = new Exception(t.getMsg());

            if (mNotShowMsg) {
                return;
            }
            onError(exception);

        } else if (mConsumer != null) { // 成功


            if (mView instanceof BaseBaseBaseIResponseView) { //如果是IResponseView，就返回给单独处理
                t.setMethodName(mMethodName);
                mConsumer.accept(t);
                mView.complete();
                mView = null;
                return;
            }


            try {

                mConsumer.accept(t);

                if (mView != null) {
                    mView.complete();
                }

            } catch (Exception e) {
                if (mNotShowMsg) {
                    return;
                }
                onError(e);
            }

        }

    }


    @Override
    public void onError(Throwable e) {
        LogUtils.e(e);
        if (mView != null) {
            if (mNotShowMsg) {
                LogUtils.i(e.toString());
                return;
            }
            if (e instanceof ConnectException) {
                mView.offline();
            } else {
                if (TextUtils.isEmpty(mMethodName)) {
                    mView.failure(e);

                } else {
                    mView.failureWithMethodName(e, mMethodName);
                }

            }
        }

    }


    @Override
    public void onComplete() {
        Logger.d("onComplete");

    }

}
