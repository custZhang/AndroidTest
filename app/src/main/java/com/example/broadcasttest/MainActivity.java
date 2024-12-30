package com.example.broadcasttest;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.net.ConnectivityManager.NetworkCallback;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

//动态注册监听网络变化
//public class MainActivity extends AppCompatActivity {
//
//    private ConnectivityManager connectivityManager;
//    private NetworkCallback networkCallback;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        networkCallback = new NetworkCallback() {
//            @Override
//            public void onAvailable(Network network) {
//                super.onAvailable(network);
//                runOnUiThread(() -> Toast.makeText(MainActivity.this, "网络已连接", Toast.LENGTH_SHORT).show());
//            }
//
//            @Override
//            public void onLost(Network network) {
//                super.onLost(network);
//                runOnUiThread(() -> Toast.makeText(MainActivity.this, "网络已断开", Toast.LENGTH_SHORT).show());
//            }
//        };
//
//        connectivityManager.registerDefaultNetworkCallback(networkCallback);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (connectivityManager != null && networkCallback != null) {
//            connectivityManager.unregisterNetworkCallback(networkCallback);
//        }
//    }
//
//
//class NetworkChangeReceiver extends BroadcastReceiver {
//
//    //当有广播到达时，就会执行这个方法
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        Toast.makeText(context, "监听到网络发生变化", Toast.LENGTH_SHORT);
//    }
//}
//}

//使用本地广播
public class MainActivity extends AppCompatActivity {


    private IntentFilter intentFilter;

    private LocalReceiver localReceiver;

    private LocalBroadcastManager localBroadcastManager;

    private MyBroadCastReceiver myBroadCastReceiver;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //注册广播管理器
//        localBroadcastManager = LocalBroadcastManager.getInstance(this);
//        View button = findViewById(R.id.button);
//        button.setOnClickListener(v -> {
//            Intent intent = new Intent("com.example.broastcasttest.LOCAL_BROADCAST");//设置要广播的种类
//            localBroadcastManager.sendBroadcast(intent);//发送广播
////            Intent intent = new Intent("com.example.broadcasttest.MY_BROADCAST");
////            MainActivity.this.sendBroadcast(intent);//发送标准广播
//        });
//        //接收广播
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("com.example.broastcasttest.LOCAL_BROADCAST");//设置监听的广播种类
//        localReceiver = new LocalReceiver();
//        localBroadcastManager.registerReceiver(localReceiver,intentFilter);

        //注册接收器，接收AndroidTest传来的广播
//        IntentFilter intentFilter2 = new IntentFilter();
//        intentFilter2.addAction("com.example.broadcasttest.MY_BROADCAST");
//        intentFilter2.setPriority(100);
//        myBroadCastReceiver = new MyBroadCastReceiver();
//        registerReceiver(myBroadCastReceiver,intentFilter2,Context.RECEIVER_EXPORTED);//第三个参数表示接收其他应用的广播
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(myBroadCastReceiver);
    }
}

class LocalReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"接受到本地广播",Toast.LENGTH_SHORT).show();
    }
}