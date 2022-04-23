package com.common.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class NotificationClickReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("TAG", "userClick:我被点击啦！！！ ");
//        Intent newIntent = new Intent(context, Main2Activity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(newIntent);
    }
}
