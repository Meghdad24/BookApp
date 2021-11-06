package com.training.one.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.training.one.R;

public class SplashActivity extends AppCompatActivity {

    private final static String LOGIN = "login";
    Boolean isLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getData();

        if (isLogin) {
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }, 4000);
        } else {
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }, 4000);
        }

    }

    private void getData() {
        SharedPreferences sharedPreferences = getSharedPreferences(LOGIN,MODE_PRIVATE);
        isLogin = sharedPreferences.getBoolean("IS_LOGIN",false);
    }
}