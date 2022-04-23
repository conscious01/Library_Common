package com.common.lib_base.common.utils;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SizeUtils;
import com.common.lib_base.common.RVItemDecoration;
import com.example.lib_base.R;


public class ViewUtils {


    /**
     * @param wholeText
     * @param targetString
     * @param tv
     * @param differentColor textview设置不同颜色
     */
    public static void textViewDifferentColor(String wholeText, String targetString, TextView tv,
                                              int differentColor) {
        SpannableString spanString = new SpannableString(wholeText);
        //构造一个改变字体颜色的Span
        ForegroundColorSpan span = new ForegroundColorSpan(differentColor);
        //将这个Span应用于指定范围的字体
        int targetPosition = wholeText.indexOf(targetString);
        if (targetPosition == -1) {
            return;
        }
        spanString.setSpan(span, targetPosition, targetPosition + 1,
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        //设置给TextView显示出来
        tv.setText(spanString);
    }


    public static void textViewDifferentColor2(String wholeText, String targetString, TextView tv,
                                               int differentColor) {
        SpannableString spanString = new SpannableString(wholeText);
        //构造一个改变字体颜色的Span
        ForegroundColorSpan span = new ForegroundColorSpan(differentColor);
        //将这个Span应用于指定范围的字体
        int targetPosition = wholeText.indexOf(targetString);
        if (targetPosition == -1) {
            return;
        }
        spanString.setSpan(span, targetPosition, targetPosition + targetString.length(),
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        //设置给TextView显示出来
        tv.setText(spanString);
    }


    /**
     * @param view
     * @param height 单位dp
     * @param width  单位dp
     */


    public static void resetViewHeightAndWidthViaPX(View view, int height, int width) {

        LogUtils.i("height=" + height + " , width=" + width);
        if (view.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams params =
                    (RelativeLayout.LayoutParams) view.getLayoutParams();
            params.width = width;
            params.height = height;
            view.setLayoutParams(params);
            return;
        }
        if (view.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams params =
                    (LinearLayout.LayoutParams) view.getLayoutParams();
            params.width = width;
            params.height = height;
            view.setLayoutParams(params);
            return;
        }
        if (view.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams params =
                    (FrameLayout.LayoutParams) view.getLayoutParams();
            params.width = width;
            params.height = height;
            view.setLayoutParams(params);
            return;
        }

    }


    /**
     * 商城价格样式
     */
    public static void setStoreText(String price, TextView textView) {
        SpannableStringBuilder spannable = new SpannableStringBuilder(price);
        spannable.setSpan(new AbsoluteSizeSpan(SizeUtils.sp2px(12)), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new AbsoluteSizeSpan(SizeUtils.sp2px(15)), 1, price.indexOf(".") + 1,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new AbsoluteSizeSpan(SizeUtils.sp2px(12)), price.indexOf(".") + 1, price.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannable);
    }


    public void margin(View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }


    @Deprecated
    public static RVItemDecoration getRVVerticalDivider(Context context) {

        return getRVDivider(context, DividerItemDecoration.VERTICAL);

    }


    public static RVItemDecoration getRVDivider(Context context, int orientation) {
        RVItemDecoration divider = new RVItemDecoration(context,
                orientation);
        divider.setDrawable(ContextCompat.getDrawable(context, R.drawable.custom_divider));
        return divider;
    }


    public static RVItemDecoration getRVDivider(Context context, int orientation,@DrawableRes int drawableId) {
        RVItemDecoration divider = new RVItemDecoration(context,
                orientation);
        divider.setDrawable(ContextCompat.getDrawable(context,drawableId));
        return divider;
    }


    public static LinearLayoutManager getRVVerticalLayoutManager(Context context) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return layoutManager;
    }


    /*获取 6300.00 券 数字和后面单位大小不一样的SpannableString，拿到之后直接setText就行*/
    public static SpannableString getMoneyAndCouponString(String moneyString) {
        SpannableString s1 = new SpannableString(moneyString);
        s1.setSpan(new AbsoluteSizeSpan(18, true), 0, s1.length() - 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        s1.setSpan(new AbsoluteSizeSpan(12, true), s1.length() - 1, s1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return s1;
    }

}
