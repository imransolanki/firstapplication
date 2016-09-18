package com.example.imran.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by imran on 18/9/16.
 */
public class OutgoingCallReceiver extends BroadcastReceiver {

    private static final String TAG = "OutgoingCallReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        Log.d(TAG, "OutgoingCallReceiver: outgoing phoneNumber = " + phoneNumber);
        Toast.makeText(context, phoneNumber, Toast.LENGTH_LONG).show();
    }
}
