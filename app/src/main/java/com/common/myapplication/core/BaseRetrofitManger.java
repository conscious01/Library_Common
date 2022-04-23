package com.common.myapplication.core;

import com.common.lib_base.base_view.BaseResEntity;
import com.common.lib_base.base_view.BaseResListEntity;
import com.common.lib_base.network.interceptor.BaseCommonParameterInterceptor;
import com.common.lib_base.network.converter.BaseEncryptGsonConverterFactory;
import com.common.myapplication.bean.EntityLoginResult;
import com.common.myapplication.bean.EntityMsg;
import java.util.concurrent.TimeUnit;

import com.google.gson.JsonObject;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


public class BaseRetrofitManger {

    private final BaseApi mWebServiceApi;

    private static BaseRetrofitManger sDataRepository;

    public static BaseRetrofitManger getInstance() {
        if (sDataRepository == null) {
            synchronized (BaseRetrofitManger.class) {

                if (sDataRepository == null) {
                    sDataRepository = new BaseRetrofitManger();
                }
            }
        }
        return sDataRepository;
    }

    BaseRetrofitManger() {
        mWebServiceApi = initialize().create(BaseApi.class);
    }

    private Retrofit initialize() {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient =
                new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS)
                        .addInterceptor(new BaseCommonParameterInterceptor())
                        .addNetworkInterceptor(logInterceptor).build();

        return new Retrofit.Builder().client(okHttpClient)
                .baseUrl(BaseUrlUtils.getInstance().getRetrofitBaseUrl())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(BaseEncryptGsonConverterFactory.create()).build();
    }

    public Observable<BaseResEntity<EntityLoginResult>> doLogin(String name, String password) {
        JsonObject jsonObject =
                new BaseJsonObject.Builder().buildWorkNo(name).setPassword(password).build();

        return mWebServiceApi.doLogin(jsonObject);
    }


    public Observable<BaseResListEntity<EntityMsg>> getMsgList(int mPage,
            String msgId) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("page", mPage);
        jsonObject.addProperty("operatorId", "f9211267-34fb-4a68-abee-cdd542006f51");
        jsonObject.addProperty("pageSize", "10");
        return mWebServiceApi.getMsgList(jsonObject);
    }

}
