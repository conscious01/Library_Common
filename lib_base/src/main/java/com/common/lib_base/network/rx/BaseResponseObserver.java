package com.common.lib_base.network.rx;

import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.blankj.utilcode.util.LogUtils;
import com.common.lib_base.base.BasicResponseEntity;
import com.common.lib_base.controller.views.core.BaseBaseBaseIResponseView;
import com.common.lib_base.controller.views.core.BaseBaseIStatusView;
import com.common.lib_base.network.core.BaseRequestPresenter;
import com.mondo.logger.Logger;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.net.ConnectException;

public class BaseResponseObserver<T extends BasicResponseEntity> implements Observer<T> {

    private BaseBaseIStatusView mView;

    private final Consumer<T> mConsumer;

    private final BaseRequestPresenter mPresenter;

    private String mMethodName;


    /**
     * 不显示后台返回的msg，默认为false，即为展示，如需不展示，ResponseObserver构造方法里设置为true即可
     */
    private boolean mNotShowMsg;

    public BaseResponseObserver(BaseRequestPresenter presenter, BaseBaseIStatusView view,
            Consumer<T> consumer) {
        this.mView = view;
        this.mConsumer = consumer;
        this.mPresenter = presenter;
    }


    public BaseResponseObserver(BaseRequestPresenter presenter, BaseBaseIStatusView view,
            Consumer<T> consumer,
            boolean notShowMsg) {
        this.mView = view;
        this.mConsumer = consumer;
        this.mPresenter = presenter;
        this.mNotShowMsg = notShowMsg;
    }

    public BaseResponseObserver(BaseRequestPresenter presenter, BaseBaseBaseIResponseView view,
            Consumer<T> consumer) {
        this.mView = view;
        this.mConsumer = consumer;
        this.mPresenter = presenter;
    }

    public BaseResponseObserver(BaseRequestPresenter presenter, BaseBaseBaseIResponseView view,
            Consumer<T> consumer, String methodName) {
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

        if (t.getCode() != 0) { // 失败

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
