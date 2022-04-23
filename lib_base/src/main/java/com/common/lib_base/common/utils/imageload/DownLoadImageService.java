package com.common.lib_base.common.utils.imageload;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.io.File;

public class DownLoadImageService implements Runnable {
    private final String url;
    private final Context context;
    private final ImageDownLoadCallBack callBack;

    public DownLoadImageService(Context context, String url, ImageDownLoadCallBack callBack) {
        this.url = url;
        this.callBack = callBack;
        this.context = context;
    }

    @Override
    public void run() {
        File file = null;
        try {
            file = Glide.with(context)
                    .load(url)

                    .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                callBack.onDownLoadSuccess(file);
            } else {
                callBack.onDownLoadFailed();
            }
        }
    }

}
