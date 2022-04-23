package com.common.lib_base.network.observer;


import android.os.Looper;


import com.common.lib_base.network.views.BaseIStatusView;
import java.net.ConnectException;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class BaseSchedulersTransformer {

    /**
     * 线程调度
     */
    public static <T> ObservableTransformer<T, T> transformer() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public static <T> ObservableTransformer<T, T> transformer(BaseIStatusView view) {

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


    public static <T> ObservableTransformer<T, T> transformer(BaseIStatusView view, boolean showLoading) {
        // 防止不在主线，调用闪退
        if (Looper.getMainLooper() == Looper.myLooper() && view != null) {
            if (showLoading) {
                view.loading();
            }
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