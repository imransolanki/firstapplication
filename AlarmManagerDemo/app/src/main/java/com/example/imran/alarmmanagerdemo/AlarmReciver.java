package com.example.imran.alarmmanagerdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by imran on 11/9/16.
 */
public class AlarmReciver extends BroadcastReceiver {
    private static final String TAG = "AlaramReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");
    }
}
