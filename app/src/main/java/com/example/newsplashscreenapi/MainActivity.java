package com.example.newsplashscreenapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;

public class MainActivity extends AppCompatActivity {
    boolean isAndroidReady = false ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        View content = findViewById(android.R.id.content);
        content.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {

               if(isAndroidReady){

                   content.getViewTreeObserver().removeOnPreDrawListener(this);
               }
               dismissSplashScreen();
                return false;
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void dismissSplashScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isAndroidReady = true;

            }
        }, 2000);

    }
}