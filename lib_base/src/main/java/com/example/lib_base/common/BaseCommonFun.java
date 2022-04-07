package com.example.lib_base.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Looper;
import android.util.Log;
import com.blankj.utilcode.util.LogUtils;
import com.example.lib_base.moddule.EntityBaseDialog;
import com.example.lib_base.ui.dialog.BaseAlertDialog;
import com.lxj.xpopup.XPopup;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


public class BaseCommonFun {

    /**
     * 功能:<br/> &nbsp;&nbsp;&nbsp;旋转Bitmap，orientationDegree角度。
     *
     * @param bm                需要旋转的图片。
     * @param orientationDegree 选择的角度。
     * @return
     */
    public static Bitmap adjustPhotoRotation(Bitmap bm, final int orientationDegree) {

        Matrix m = new Matrix();
        m.setRotate(orientationDegree, (float) bm.getWidth() / 2, (float) bm.getHeight() / 2);
        float targetX, targetY;
        if (orientationDegree == 90) {
            targetX = bm.getHeight();
            targetY = 0;
        } else {
            targetX = bm.getHeight();
            targetY = bm.getWidth();
        }

        final float[] values = new float[9];
        m.getValues(values);

        float x1 = values[Matrix.MTRANS_X];
        float y1 = values[Matrix.MTRANS_Y];

        m.postTranslate(targetX - x1, targetY - y1);

        Bitmap bm1 = null;

        try {
            bm1 = Bitmap.createBitmap(bm.getHeight(), bm.getWidth(), Bitmap.Config.ARGB_4444);
        } catch (Exception e) {

            bm.recycle();
            bm = null;

            return null;
        }

        Paint paint = new Paint();
        Canvas canvas = new Canvas(bm1);
        canvas.drawBitmap(bm, m, paint);

        bm.recycle();
        bm = null;

        // Bitmap mFreeBitmap = Bitmap.createBitmap(0, 0, Bitmap.Config.RGB_565);
        // canvas.setBitmap(mFreeBitmap);

        canvas = null;

        return bm1;

    }

    /**
     * 用于放大缩小图片
     *
     * @param bitmap
     * @param w
     * @param h
     * @return
     */
    public static Bitmap zoomBitmap(Bitmap bitmap, int w, int h) {

        if (bitmap == null) {
            return null;
        }

        int width = bitmap.getWidth(); // 176
        int height = bitmap.getHeight(); // 144
        Matrix matrix = new Matrix();
        float scaleWidht = ((float) w / width); // 2.0
        float scaleHeight = ((float) h / height); // 2.0
        matrix.postScale(scaleWidht, scaleHeight);

        try {

            Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);

            return newbmp;
        } catch (OutOfMemoryError e) {
            Log.i("WIDTH,HEIGHT，ERROR", "到这里来了!");
        } finally {
            bitmap.recycle();

        }

        return null;

    }

    /**
     * 功能:<br/> &nbsp;&nbsp;&nbsp;等比缩放。
     *
     * @param bitmap  图片。
     * @param iWidth  范围限制的宽度。
     * @param iHeight 范围限制的高度。
     * @return null 等比缩放失败。<br/> 非null 等比缩放成功。
     */
    public static Bitmap equalRatioZoom(Bitmap bitmap, int iWidth, int iHeight) {

        // 如果要被缩放的图片自身为null,则返回缩放失败。
        if (bitmap == null) {
            return null;
        }

        // 宽度和高度为0，则转换失败。
        if (iWidth == 0 || iHeight == 0) {
            return null;
        }

        // 获得照片的自己的宽高比。
        float fBmpRadio = ((float) bitmap.getWidth()) / (float) bitmap.getHeight();
        // 定义是否以横向为约束的变量。
        boolean isHorizScale = true;

        // 如果以约束范围的宽为图片的宽，得此时等比缩放的图片的高度应该为
        int iNowHeight = (int) (((float) iWidth) / fBmpRadio);

        if (iNowHeight > iHeight) {

            isHorizScale = false;
        }

        // 计算缩放后的图片的大小。
        int iDstWidth = 0;
        int iDstHeight = 0;

        if (isHorizScale == true) {

            iDstWidth = iWidth;
            iDstHeight = (int) ((((float) bitmap.getHeight()) / bitmap.getWidth()) * iWidth);
        } else {

            iDstWidth = (int) ((((float) bitmap.getWidth() / bitmap.getHeight())) * iHeight);
            iDstHeight = iHeight;
        }

        return BaseCommonFun.zoomBitmap(bitmap, iDstWidth, iDstHeight);

    }

    /**
     * 质量压缩方法
     *
     * @param image
     * @param iExpectedFileSize 期望大小。
     * @return
     */
    public static Bitmap compressImage(Bitmap image, int iExpectedFileSize) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);// 质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中

        int options = 90;

        while (baos.toByteArray().length / 1024
                > iExpectedFileSize) { // 循环判断如果压缩后图片是否大于100kb,大于继续压缩

            baos.reset(); // 重置baos即清空baos
            image.compress(Bitmap.CompressFormat.JPEG, options,
                    baos);// 这里压缩options%，把压缩后的数据存放到baos中

            options -= 10;// 每次都减少10
        }

        LogUtils.i("压缩之后的bitmap 大小：", baos.toByteArray().length / 1024);
        ByteArrayInputStream isBm = new ByteArrayInputStream(
                baos.toByteArray());// 把压缩后的数据baos存放到ByteArrayInputStream中
        Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, null);// 把ByteArrayInputStream数据生成图片

        return bitmap;
    }


    public static void showFriendAlertDialog(Context context, EntityBaseDialog entityBaseDialog) {

        new XPopup.Builder(context)
                .dismissOnTouchOutside(false)
                .hasStatusBar(false)
                .dismissOnBackPressed(false)
                .asCustom(new BaseAlertDialog(context, entityBaseDialog))
                .show();

    }

    public static void runUICode(Runnable runnable) {

        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            GlobalHandler.getInstance().post(runnable);
        }

    }

}
