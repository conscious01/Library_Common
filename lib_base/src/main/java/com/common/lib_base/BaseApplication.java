package com.common.lib_base;

import static androidx.multidex.BuildConfig.DEBUG;

import com.blankj.utilcode.util.LogUtils;
import com.common.lib_base.common.image.GlideApp;
import com.common.lib_base.common.utils.CrashHelper;
import java.io.PrintWriter;
import java.io.StringWriter;


import com.mondo.logger.AndroidLogAdapter;
import com.mondo.logger.Logger;
import com.qbw.spm.P;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.wanjian.cockroach.Cockroach;

import android.content.Context;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import io.reactivex.plugins.RxJavaPlugins;
import me.weishu.reflection.Reflection;

public class BaseApplication extends MultiDexApplication {

    private static final String TAG = "MyApplication";

    static {

        SmartRefreshLayout.setDefaultRefreshInitializer(
                (context, layout) -> layout.setReboundDuration(300)
                        .setEnableAutoLoadMore(true)
                        .setDragRate(0.4f)
                        .setEnableOverScrollBounce(true)
                        .setDisableContentWhenLoading(false));

        SmartRefreshLayout.setDefaultRefreshHeaderCreator(
                (context, layout) -> new ClassicsHeader(context).setTextSizeTitle(12)
                        .setEnableLastTime(false)
                        .setDrawableSize(15)
                        .setDrawableMarginRight(6)
                        .setSpinnerStyle(SpinnerStyle.Translate)
                        .setFinishDuration(500));

        SmartRefreshLayout.setDefaultRefreshFooterCreator(
                (context, layout) -> new ClassicsFooter(context).setTextSizeTitle(12)
                        .setFinishDuration(500)
                        .setDrawableSize(15)
                        .setDrawableMarginRight(8)
                        .setSpinnerStyle(SpinnerStyle.Translate));

        // 日志框架
        Logger.addLogAdapter(new AndroidLogAdapter() {

            @Override
            public boolean isLoggable(int priority, String tag) {
                return DEBUG;
            }

        });

    }

    public static BaseApplication mInstantce;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstantce = this;
        LogUtils.i(TAG, "我被初始化了");
        initCrashHandler();
        initThirdService();

//        // 创建通知渠道
//        AppNotificationJava.createNotificationChannel(
//                        this,
//                        AppNotificationJava.msgChannelId,
//                        AppNotificationJava.msgChannelName,
//                        AppNotificationJava.mediaChannelImportance);

    }


    private void initCrashHandler() {
        Cockroach.install((thread, throwable) -> {

            StringWriter stackTrace = new StringWriter();
            throwable.printStackTrace(new PrintWriter(stackTrace));
            String strExceptionInfo = stackTrace.toString();
            LogUtils.e(strExceptionInfo);
        });

    }

    /**
     * 初始化第三方服务
     */
    private void initThirdService() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 处理RxJava取消订阅异常无法抛出导致闪退问题
                initializeRxJavaException();
                P.init(getContext(), false);
            }
        }).start();

    }

    private void initializeRxJavaException() {
        try {
            RxJavaPlugins.setErrorHandler(CrashHelper::generateCustomLog);
        } catch (Exception e) {
            CrashHelper.generateCustomLog(e);
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
        Reflection.unseal(base);
    }

    public static Context getContext() {
        return mInstantce;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        GlideApp.with(this).onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        GlideApp.with(this).onTrimMemory(level);
    }
}
