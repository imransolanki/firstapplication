package com.example.imran.firstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class LoginActivity extends Activity {

    public static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // retrieve passed data
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String userEmail = bundle.getString("EXTRA_USER_EMAIL");
            Log.d(TAG, "onCreate: userEmail=" + userEmail);
        }
    }

    public void closeActivity(View view) {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

}
