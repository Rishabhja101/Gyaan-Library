
package com.example.risha.gyaanlibrary;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */

public class SplashScreenActivity extends AppCompatActivity {

    int percent = 0;
    TextView percentText;
    int randomInt;
    int delay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        final Random random = new Random();
        percentText = findViewById(R.id.textView);

        while (percent < 100) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    randomInt = random.nextInt(5) + 2;
                    percent += randomInt;
                    percentText.setText(String.valueOf(randomInt));

                    Random randDelay = new Random();
                    delay = randDelay.nextInt(2000) + 750;
                }
            }, delay);  
        }
    }
}