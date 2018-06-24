package com.webview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Fragment_Test extends AppCompatActivity {
    private IntentFilter intentFilter;

    private NetworkChangeReceiver networkChangeReceiver;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment__test);

        intentFilter=new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver=new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }
    class NetworkChangeReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
           //Toast.makeText(context,"networkchange",Toast.LENGTH_SHORT).show();//只有变化
            ConnectivityManager connectionManager = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable()) {
               Toast.makeText(context, "network is available",
                        Toast.LENGTH_SHORT).show();
           } else {
                Toast.makeText(context, "network is unavailable",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
