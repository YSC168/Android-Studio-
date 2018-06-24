package com.webview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Myboardcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving`1
        // an Intent broadcast.
        Toast.makeText(context,"ni hao",Toast.LENGTH_SHORT).show();
        abortBroadcast();//广播拦截
        //好像没有什么用throw new UnsupportedOperationException("Not yet implemented");

    }
}
