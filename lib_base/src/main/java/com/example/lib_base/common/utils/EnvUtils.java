package com.example.lib_base.common.utils;


import com.example.lib_base.common.ConS;

public class EnvUtils {

    private static class Holder {
        private static EnvUtils INSTANCE = new EnvUtils();
    }

    private EnvUtils() {}

    public static EnvUtils getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * @return 网络请求的retrofit设置的baseurl
     */
    public String getRetrofitBaseUrl() {

        return "http://parking.unioncore.vip";

    }

}
