package com.common.lib_base.controller.views.core;

public class BaseCallbackResultDecoratorBase<T> implements BaseBaseBaseICallbackResult<T> {

    private final BaseBaseBaseICallbackResult<T> mCallbackResult;

    public BaseCallbackResultDecoratorBase(BaseBaseBaseICallbackResult<T> callbackResult) {
        this.mCallbackResult = callbackResult;
    }

    @Override
    public void successful(T result) {
        mCallbackResult.successful(result);
    }

    @Override
    public void loading() {
        mCallbackResult.loading();
    }

    @Override
    public void failure(Throwable throwable) {
        mCallbackResult.failure(throwable);
    }

    @Override
    public void complete() {
        mCallbackResult.complete();
    }

    @Override
    public void offline() {
        mCallbackResult.offline();
    }

}
