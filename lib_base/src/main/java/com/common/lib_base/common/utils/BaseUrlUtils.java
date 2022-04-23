package com.common.lib_base.common.utils;


public class BaseUrlUtils {

    private static class Holder {
        private static BaseUrlUtils INSTANCE = new BaseUrlUtils();
    }

    private BaseUrlUtils() {}

    public static BaseUrlUtils getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * @return 网络请求的retrofit设置的baseurl
     */
    public String getRetrofitBaseUrl() {

        return "http://parking.unioncore.vip";

    }

}
