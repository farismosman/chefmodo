package com.chefmodo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.chefmodo.homeActivity.HomeActivity;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        startHomeActivity();
    }

    private void startHomeActivity() {
        final Intent homeIntent = new Intent(this, HomeActivity.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(homeIntent);
            }
        }, 2000);
    }
}
