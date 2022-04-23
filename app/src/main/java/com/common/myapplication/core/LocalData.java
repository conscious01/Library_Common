package com.common.myapplication.core;

import android.content.Context;
import android.content.SharedPreferences;

import com.blankj.utilcode.util.LogUtils;
import com.common.lib_base.BaseApplication;
import com.qbw.spm.P;


public class LocalData {

    /*------------单例初始化-----------------------------------------------------------------------*/
    private static class Holder {

        private static LocalData INSTANCE = new LocalData();
    }

    private LocalData() {
        initData();
    }

    private void initData() {
    }

    public static LocalData getInstance() {
        return Holder.INSTANCE;
    }

    /*------------单例初始化-----------------------------------------------------------------------*/



    /*------------常用赋值-----------------------------------------------------------------------*/

    public boolean getBoolean(String key, boolean defaultValue) {
        boolean value = defaultValue;
        try {
            value = P.getBoolean(key, defaultValue);
        } catch (Exception e) {
            LogUtils.i(e);
        }
        return value;
    }

    public void putBoolean(String key, boolean value) {
        P.putBoolean(key, value);
    }

    public void putString(String key, String value) {
        P.putString(key, value);
    }

    public String getString(String key) {
        String value = "";
        try {
            value = P.getString(key, "");
        } catch (Exception e) {
            LogUtils.i(e);
        }
        return value;
    }

    public String getString(String key, String defaultValue) {
        String value = "";
        try {
            value = P.getString(key, defaultValue);
        } catch (Exception e) {
            LogUtils.i(e);
        }
        return value;
    }


    public Long getLong(String key) {
        long value = 0;
        try {
            value = P.getLong(key, 0);
        } catch (Exception e) {
            LogUtils.i(e);
        }
        return value;
    }


    public int getInt(String key, int v) {
        int value = 0;
        try {
            value = P.getInt(key, v);
        } catch (Exception e) {
            LogUtils.i(e);
        }
        return value;
    }

    public void putInt(String key, int v) {
        P.putInt(key, v);

    }

    public void putLong(String key, long v) {
        P.putLong(key, v);
    }


    /*------------常用赋值-----------------------------------------------------------------------*/


    /*------------保存实体类-----------------------------------------------------------------------*/
//
//    private EntityLoginResult mUserInfo;
//
//    public void setUserInfo(EntityLoginResult user) {
//        mUserInfo = user;
//        P.putObject(ConS.USER_INFO, user);
//    }
//
//    public EntityLoginResult getUserInfo() {
//        if (mUserInfo == null) {
//            mUserInfo = P.getObject(ConS.USER_INFO, EntityLoginResult.class);
//        }
//        return mUserInfo;
//    }
    /*------------保存实体类-----------------------------------------------------------------------*/



    /**
     * 删除本地SharedPreferences
     */
    public void clearSpData() {
        SharedPreferences sSharedPreferences =
                BaseApplication.mInstantce.getSharedPreferences("P_qbw", Context.MODE_PRIVATE);
        sSharedPreferences.edit().clear().apply();
    }


}
