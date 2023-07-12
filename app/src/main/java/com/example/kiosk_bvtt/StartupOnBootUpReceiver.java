package com.example.kiosk_bvtt;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class StartupOnBootUpReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
//        Hàm tự khởi dộng khi chạy lại thiết bị
        Log.v("aaaaaaaaaa","aaaaaaaaaaaaa");
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Intent intent2 = new Intent(context, MainActivity.class);
            intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent2);
        }
    }
}



