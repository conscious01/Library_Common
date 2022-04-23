package com.common.lib_base.network;

import com.common.lib_base.base.BasicResponseEntity;
import com.common.lib_base.network.converter.BaseEncryptGsonConverterFactory;
import com.common.lib_base.common.utils.EnvUtils;
import com.common.lib_base.common.utils.RequestJsonObject;
import com.common.lib_base.network.interceptor.BaseCommonParameterInterceptor;
import java.util.concurrent.TimeUnit;

import com.google.gson.JsonObject;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * 远程/网络 数据源
 */
public class BaseRemoteDataSource implements BaseIDataSource {

    private final BaseWebServiceApi mWebServiceApi;

    private static BaseIDataSource sDataRepository;

    public static BaseIDataSource getInstance() {
        if (sDataRepository == null) {
            synchronized (BaseRemoteDataSource.class) {

                if (sDataRepository == null) {
                    sDataRepository = new BaseRemoteDataSource();
                }
            }
        }
        return sDataRepository;
    }

    BaseRemoteDataSource() {
        mWebServiceApi = initialize().create(BaseWebServiceApi.class);
    }

    private Retrofit initialize() {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient =
            new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new BaseCommonParameterInterceptor()).addNetworkInterceptor(logInterceptor).build();

        return new Retrofit.Builder().client(okHttpClient).baseUrl(EnvUtils.getInstance().getRetrofitBaseUrl())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(BaseEncryptGsonConverterFactory.create()).build();
    }

    @Override
    public Observable<BasicResponseEntity<String>> doLogin(String name, String password, String deviceId) {

        JsonObject jsonObject =
            new RequestJsonObject.Builder().buildWorkNo(name).setPassword(password).build();

        return mWebServiceApi.doLogin(jsonObject);
    }


}
