package com.common.lib_base.network.rx;


import android.os.Looper;


import com.common.lib_base.controller.views.core.BaseBaseIStatusView;
import java.net.ConnectException;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Author: LJD
 * Date: 2019/9/6
 * Desc: 转换请求
 */
public class BaseSchedulersTransformer {

    /**
     * 线程调度
     */
    public static <T> ObservableTransformer<T, T> transformer() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public static <T> ObservableTransformer<T, T> transformer(BaseBaseIStatusView view) {

        // 防止不在主线，调用闪退
        if (Looper.getMainLooper() == Looper.myLooper() && view != null) {
            view.loading();
        }

        return upstream -> upstream
                .compose(transformer())
                .doOnComplete(() -> {
                    //if (view != null) view.complete();
                })
                .doOnError(throwable -> {
                    if (view != null) {
                        if (throwable instanceof ConnectException) {

                            view.offline();

                        } else {
                            view.failure(throwable);
                        }
                    }
                });
    }
}