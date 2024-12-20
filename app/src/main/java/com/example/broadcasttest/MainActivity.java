package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Bundle;
import android.widget.Toast;
import android.net.ConnectivityManager.NetworkCallback;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

//    private IntentFilter intentFilter;
//
//    private NetworkChangeReceiver networkChangeReceiver;

    private ConnectivityManager connectivityManager;
    private NetworkCallback networkCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        //1.监听网路变化
//        //  先给intentFilter添加网络的行为
//        //  想要监听什么广播，就在这里添加对应的行为
//        intentFilter = new IntentFilter();
//        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//        //  放到changeReceiver里
//        networkChangeReceiver = new NetworkChangeReceiver();
//        registerReceiver(networkChangeReceiver,intentFilter);

        connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        networkCallback = new NetworkCallback() {
            @Override
            public void onAvailable(Network network) {
                super.onAvailable(network);
                runOnUiThread(() -> Toast.makeText(MainActivity.this, "网络已连接", Toast.LENGTH_SHORT).show());
            }

            @Override
            public void onLost(Network network) {
                super.onLost(network);
                runOnUiThread(() -> Toast.makeText(MainActivity.this, "网络已断开", Toast.LENGTH_SHORT).show());
            }
        };

        connectivityManager.registerDefaultNetworkCallback(networkCallback);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (connectivityManager != null && networkCallback != null) {
            connectivityManager.unregisterNetworkCallback(networkCallback);
        }
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        //广播接收器最后要记得取消注册
//        unregisterReceiver(networkChangeReceiver);
//    }
}

class NetworkChangeReceiver extends BroadcastReceiver {

    //当有广播到达时，就会执行这个方法
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"监听到网络发生变化",Toast.LENGTH_SHORT);
    }
}