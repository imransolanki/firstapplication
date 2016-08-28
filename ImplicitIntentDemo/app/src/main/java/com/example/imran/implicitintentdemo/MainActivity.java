package com.example.imran.implicitintentdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick_implicitIntent(View view) {
        //openBrowser();
        launchMusicPlayer();
        //sendSMS();
        //chooseContact();
        //launchCamer();
    }

    private void openBrowser() {
        // start browser
        Intent browserIntent = new Intent();
        browserIntent.setAction(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse("http://www.facebook.com"));
        startActivity(browserIntent);
    }

    private void launchMusicPlayer() {
        Intent musicPlayerIntent = new Intent();
        musicPlayerIntent.setAction(MediaStore.INTENT_ACTION_MUSIC_PLAYER);
        startActivity(musicPlayerIntent);
    }

    private void sendSMS() {
        Intent smsIntent = new Intent();
        smsIntent.setAction(Intent.ACTION_VIEW);
        smsIntent.setData(Uri.parse("smsto:9763067364"));

        if (smsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(smsIntent);
        } else {
            Toast.makeText(MainActivity.this, "No Application Found", Toast.LENGTH_SHORT).show();
        }
    }

    private void chooseContact() {
        Intent contactChooserIntent = new Intent();
        contactChooserIntent.setAction(Intent.ACTION_VIEW);
        contactChooserIntent.setData(ContactsContract.Contacts.CONTENT_URI);

        if (contactChooserIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(contactChooserIntent);
        } else {
            Toast.makeText(MainActivity.this, "Contacts Application not present", Toast.LENGTH_SHORT).show();
        }
    }

    private void launchCamer() {
        Intent cameraIntent = new Intent();
        cameraIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        if (cameraIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(cameraIntent);
        } else {
            Toast.makeText(MainActivity.this, "Camera Application not present", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
