package com.webview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootBoardcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context,"最初的梦想",Toast.LENGTH_SHORT).show();
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
