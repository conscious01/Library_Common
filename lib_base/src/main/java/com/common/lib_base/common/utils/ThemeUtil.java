package com.common.lib_base.common.utils;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.content.res.TypedArray;

import androidx.annotation.ColorInt;
import com.example.lib_base.R;


@SuppressLint("ResourceAsColor")
public class ThemeUtil {

    public static @ColorInt
    int getBackgroundColor(Resources.Theme theme) {
        int[] attrsArray = {R.attr.backgroundColor};
        TypedArray typedArray = theme.obtainStyledAttributes(attrsArray);
        return typedArray.getColor(0, R.color.backgroundColor);
    }

}
