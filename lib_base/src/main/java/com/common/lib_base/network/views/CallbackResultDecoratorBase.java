package com.common.lib_base.network.views;

public class CallbackResultDecoratorBase<T> implements BaseICallbackResult<T> {

    private final BaseICallbackResult<T> mCallbackResult;

    public CallbackResultDecoratorBase(BaseICallbackResult<T> callbackResult) {
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
