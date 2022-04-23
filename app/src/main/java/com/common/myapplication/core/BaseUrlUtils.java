package com.common.myapplication.core;


public class BaseUrlUtils {

    private static class Holder {
        private static BaseUrlUtils INSTANCE = new BaseUrlUtils();
    }

    private BaseUrlUtils() {}

    public static BaseUrlUtils getInstance() {
        return Holder.INSTANCE;
    }


    public String getRetrofitBaseUrl() {

        return "http://iottest.unioncore.vip";

    }

}
