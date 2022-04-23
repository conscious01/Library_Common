package com.common.lib_base.common.utils;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.example.lib_base.R;


public class ActivityTitleHelper {

    public static void setTitle(Activity activity, @StringRes int title) {
        TextView tvTitle = activity.findViewById(R.id.tv_title);
        tvTitle.setText(title);
        activity.findViewById(R.id.iv_arrow_back).setOnClickListener(v -> activity.onBackPressed());
    }

    public static void setTitle(ViewGroup parent, @StringRes int title) {
        Activity activity = (Activity) parent.getContext();
        TextView tvTitle = parent.findViewById(R.id.tv_title);
        tvTitle.setText(title);
        parent.findViewById(R.id.iv_arrow_back).setOnClickListener(v -> activity.onBackPressed());
    }

    public static void setTitle(Activity activity, @StringRes int title, @StringRes int action) {
        TextView tvTitle = activity.findViewById(R.id.tv_title);
//        TextView tvAction = activity.findViewById(R.id.tv_action);
        tvTitle.setText(title);
//        tvAction.setText(action);
        activity.findViewById(R.id.iv_arrow_back).setOnClickListener(v -> activity.onBackPressed());
    }

    public static void setTitle(Activity activity, String title) {
        TextView tvTitle = activity.findViewById(R.id.tv_title);
        tvTitle.setText(title);
        activity.findViewById(R.id.iv_arrow_back).setOnClickListener(v -> activity.onBackPressed());
    }

    public static void setTitle(Activity activity, String title, String action) {
        TextView tvTitle = activity.findViewById(R.id.tv_title);
//        TextView tvAction = activity.findViewById(R.id.tv_action);
        tvTitle.setText(title);
//        tvAction.setText(action);
        activity.findViewById(R.id.iv_arrow_back).setOnClickListener(v -> activity.onBackPressed());
    }

    /*右边textview加下划线*/
    public static void setTitleActionUnderLine(Activity activity, String title, String action) {
        TextView tvTitle = activity.findViewById(R.id.tv_title);
//        TextView tvAction = activity.findViewById(R.id.tv_action);
        tvTitle.setText(title);
//        tvAction.setText(action);
//        tvAction.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
//        tvAction.getPaint().setAntiAlias(true);//抗锯齿

        activity.findViewById(R.id.iv_arrow_back).setOnClickListener(v -> activity.onBackPressed());
    }


    public static void setTitle_GoneImg(Activity activity, @StringRes int title) {
        TextView tvTitle = activity.findViewById(R.id.tv_title);
        tvTitle.setText(title);
        activity.findViewById(R.id.iv_arrow_back).setVisibility(View.GONE);
    }


}
