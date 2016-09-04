package com.gslab.imran.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

/**
 * Created by imran on 4/9/16.
 */
public class MusicPlayerService extends Service {
    private static final String TAG = "MusicPlayer";

    private MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");

        String songPath = intent.getStringExtra("songPath");
        try {
            mediaPlayer.setDataSource(songPath);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.start();

        // You never write such code, this is for demo purpose
//        try {
//            Thread.sleep(5 * 1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // API to stop current service
        //stopSelf();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");

        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        super.onDestroy();
    }
}
