package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("MyBroadCastReceiver","到达广播接收器");
        Toast.makeText(context,"BroadCastTest项目的广播接收器 收到数据",Toast.LENGTH_SHORT).show();
        abortBroadcast();
    }
}
