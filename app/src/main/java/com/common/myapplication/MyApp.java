package com.common.myapplication;

import com.blankj.utilcode.util.LogUtils;
import com.common.lib_base.BaseApplication;

public class MyApp extends BaseApplication {


    public MyApp() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.i(this, "我被初始化了");
    }
}
