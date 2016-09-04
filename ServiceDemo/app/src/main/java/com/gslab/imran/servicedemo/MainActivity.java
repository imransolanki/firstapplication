package com.gslab.imran.servicedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Intent musicService;
    private Intent musicIntentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void startSong(View view) {
        startMusicService();
//        startMusicIntentService();
    }

    private void startMusicIntentService() {
        musicIntentService = new Intent(this, MusicPlayerIntentService.class);
        musicIntentService.putExtra("songPath", "/mnt/sdcard/sultan.mp3");
        startService(musicIntentService);
    }

    private void startMusicService() {
        musicService = new Intent(this, MusicPlayerService.class);
        musicService.putExtra("songPath", "/mnt/sdcard/sultan.mp3");
        startService(musicService);
    }

    public void stopSong(View view) {

        if (musicService != null) {
            stopService(musicService);
        }

        if (musicIntentService != null) {
            stopService(musicIntentService);
        }
    }
}
