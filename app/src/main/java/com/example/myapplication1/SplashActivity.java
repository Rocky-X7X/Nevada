package com.example.myapplication1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

// SplashActivity.java
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Intent intent = new Intent(SplashActivity.this, Inventura.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
        // Zobrazí splash screen 3 sekundy
    }
}