package com.example.imran.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BatteryReceiver batteryReceiver = null;

    private BroadcastReceiver uiBatteryReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            batteryLevel.setText(level + "");
        }
    };

    private BroadcastReceiver alertReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String alert = intent.getStringExtra("ALERT_MESSAGE");
            alertMessage.setText(alert);
        }
    };

    private TextView batteryLevel;
    private TextView alertMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        batteryLevel = (TextView) findViewById(R.id.batteryLevel);
        alertMessage = (TextView) findViewById(R.id.alertMessage);

        // registerBatteryReceiver();
        registerReceiver(uiBatteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        registerReceiver(alertReceiver, new IntentFilter("com.example.imran.broadcastreceiverdemo.ACTION_ALERT"));
    }

    private void registerBatteryReceiver() {
        // register for battery event
        batteryReceiver = new BatteryReceiver();
        registerReceiver(batteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }


    public void generateCustomBroadcast(View view) {
        sendAlert("Help Me!");
    }

    private void sendAlert(String alertMessage) {
        Intent alertIntent = new Intent("com.example.imran.broadcastreceiverdemo.ACTION_ALERT");
        alertIntent.putExtra("ALERT_MESSAGE", alertMessage);
        sendBroadcast(alertIntent);

    }

    @Override
    protected void onStop() {

        if (batteryReceiver != null) {
            unregisterReceiver(batteryReceiver);
        }

        if (uiBatteryReceiver != null) {
            unregisterReceiver(uiBatteryReceiver);
        }

        if (alertReceiver != null) {
            unregisterReceiver(alertReceiver);
        }

        super.onStop();
    }
}
