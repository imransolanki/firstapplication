package com.example.imran.firstapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by imran on 6/8/16.
 */
public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private static final int LOGIN_ACTIVITY_REQ_CODE = 1;

    private TextView userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userEmail = (TextView) findViewById(R.id.user_email);

        if (savedInstanceState != null) {
            String email = savedInstanceState.getString("USER_EMAIL");
            email = email + "(Activity re-created)";
            userEmail.setText(email);
        }

        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("USER_EMAIL", userEmail.getText().toString().trim());
        super.onSaveInstanceState(outState);
    }

    public void startActivityLogin(View view) {
        // code to start login activity
        Intent loginActivity = new Intent(getApplicationContext(), LoginActivity.class);
        // code to pass data to login activity
        loginActivity.putExtra("EXTRA_USER_EMAIL", "imran.solanki@gmail.com");
        //startActivity(loginActivity);
        startActivityForResult(loginActivity, LOGIN_ACTIVITY_REQ_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == LOGIN_ACTIVITY_REQ_CODE && resultCode == Activity.RESULT_OK) {
            Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
        }
        if (requestCode == LOGIN_ACTIVITY_REQ_CODE && resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
        }
    }
}
