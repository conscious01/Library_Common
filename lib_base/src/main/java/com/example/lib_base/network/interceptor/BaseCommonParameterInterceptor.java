package com.example.lib_base.network.interceptor;


import com.blankj.utilcode.util.DeviceUtils;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/**
 * 公共参数
 */
public class BaseCommonParameterInterceptor implements Interceptor {

    private final String mUniqueDeviceId; // 设备唯一ID
    private final String mBrand; // 品牌
    private final String mModel; // 型号


    public BaseCommonParameterInterceptor() {
        mModel = DeviceUtils.getModel();
        mBrand = android.os.Build.BRAND;
        mUniqueDeviceId = DeviceUtils.getUniqueDeviceId();
    }


    @NotNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder requestBuilder = addHeaders(original);

        return chain.proceed(requestBuilder.build());
    }


    private Request.Builder addHeaders(Request request) {
        Request.Builder header = request.newBuilder();

        Request.Builder requestHeader = request.newBuilder()
                .header("os", "1") // 客户端平台，1-安卓，2-IOS
                .header("device-id", mUniqueDeviceId) // 设备唯一ID
                .header("brand", mBrand) // 品牌
                .header("model", mModel) // 型号
                ;

        return header;
    }


}

