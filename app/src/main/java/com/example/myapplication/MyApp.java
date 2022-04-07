package com.example.myapplication;

import com.blankj.utilcode.util.LogUtils;
import com.example.lib_base.BaseApplication;

public class MyApp extends BaseApplication {


    public MyApp() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.i(this, "我被初始化了");
    }
}
