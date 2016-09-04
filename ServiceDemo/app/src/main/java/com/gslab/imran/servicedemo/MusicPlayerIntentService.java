package com.gslab.imran.servicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by imran on 4/9/16.
 */
public class MusicPlayerIntentService extends IntentService {

    private MediaPlayer mediaPlayer;

    public MusicPlayerIntentService() {
        super("MusicPlayerEmptyContructor");
    }

    public MusicPlayerIntentService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String songPath = intent.getStringExtra("songPath");
        try {
            mediaPlayer.setDataSource(songPath);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
