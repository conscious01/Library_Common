package com.example.lib_base.common.utils;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * 退出登录的时候不需要被删除的缓存配置保存工具类
 */
public class SPUtilNoDelete {

    private final String FILLNAME = "config_no_delete";// 文件名称
    private SharedPreferences mSharedPreferences = null;

    private static Context context;

    public static void setContext(Context context2) {
        SPUtilNoDelete.context = context2;
    }

    private static class Holder {

        private static final SPUtilNoDelete INSTANCE = new SPUtilNoDelete();
    }

    private SPUtilNoDelete() {
        mSharedPreferences = SPUtilNoDelete.context
                .getSharedPreferences(FILLNAME, Context.MODE_PRIVATE);

    }

    public static SPUtilNoDelete getInstance() {
        return Holder.INSTANCE;
    }


    /**
     * SharedPreferences常用的10个操作方法
     */
    public void putBoolean(String key, boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return mSharedPreferences.getBoolean(key, defValue);
    }

    public void putString(String key, String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }

    public String getString(String key, String defValue) {
        return mSharedPreferences.getString(key, defValue);
    }

    public void putInt(String key, int value) {
        mSharedPreferences.edit().putInt(key, value).apply();
    }

    public int getInt(String key, int defValue) {
        return mSharedPreferences.getInt(key, defValue);
    }

    /**
     * 移除某个key值已经对应的值
     */
    public void remove(String key) {
        mSharedPreferences.edit().remove(key).apply();
    }

    /**
     * 清除所有内容
     */
    public void clear() {
        mSharedPreferences.edit().clear().apply();
    }

}
