package com.example.lib_base.common.utils;

import com.mondo.logger.Logger;

/**
 * 崩溃捕捉对象
 */
public class CrashHelper {

    public static void generateCustomLog(Throwable t) {
        Logger.e(t, t.getMessage());

    }

}
