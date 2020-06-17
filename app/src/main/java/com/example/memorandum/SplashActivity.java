package com.example.memorandum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //load the password
        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        password = settings.getString("Password","");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (password.equals("")){
                    //if there is no password
                    Intent intent = new Intent(getApplicationContext(),CreatePassword.class);
                    startActivity(intent);
                    finish();

                }else {
                    //if there is a password
                    Intent intent = new Intent(getApplicationContext(),EnterPassword.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, 2000);
    }
}
