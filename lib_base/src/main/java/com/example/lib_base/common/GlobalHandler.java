package com.example.lib_base.common;

import android.os.Handler;
import android.os.Looper;

public class GlobalHandler {


    private static Handler globalHandler;

    public static Handler getInstance() {

        if (globalHandler == null) {
            synchronized (GlobalHandler.class) {
                if (globalHandler == null) {
                    globalHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        return globalHandler;

    }


}
