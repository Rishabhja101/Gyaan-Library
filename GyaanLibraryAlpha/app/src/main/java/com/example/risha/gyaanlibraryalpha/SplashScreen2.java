package com.example.risha.gyaanlibraryalpha;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SplashScreen2 extends AppCompatActivity {

    int percent = 0;
    //    TextView percentText;
    int randomInt;
    int delay;
    TextView percentText;
    ContentLoadingProgressBar pBar;
    Handler myHandler;
    ProgressBar circle;
    com.mikhaellopez.circularprogressbar.CircularProgressBar circle2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);

        percentText = findViewById(R.id.percentText);
        pBar = findViewById(R.id.progressBar);
        circle = findViewById(R.id.circleProgress);
        circle2 = findViewById(R.id.circleProgress2);

        myHandler = new Handler();

        final Random random = new Random();

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        // Execute your delayed code
                        while (percent < 100) {
                            randomInt = random.nextInt(3) + 2;
                            percent += randomInt;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (percent <= 100) {
                                        percentText.setText(String.valueOf(percent) + "%");
                                    } else {
                                        percentText.setText("100%");
                                    }
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                                        pBar.setProgress(percent, true);
                                        circle2.setProgress(percent);
                                        circle.setProgress(percent, true);
                                    }
                                }
                            });
                            Random randDelay = new Random();
                            delay = randDelay.nextInt(200) + 100;
                            wait(delay);
                        }
                        Intent intent = new Intent(SplashScreen2.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } catch (InterruptedException ex) {
                    Toast.makeText(SplashScreen2.this, "Interrupted Exception: " + ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        };

        thread.start();

/*
        while (percent < 100) {
//            Handler handler = new Handler();
            myHandler.postDelayed(new Runnable() {
                public void run() {
                    // Execute your delayed code
                    randomInt = random.nextInt(3) + 2;
                    percent += randomInt;
                    textView.setText(String.valueOf(percent));
                    Random randDelay = new Random();
                    delay = randDelay.nextInt(1000) + 750;
                 /*
                }
        Intent intent = new Intent(SplashScreen2.this, LoginActivity.class);
        startActivity(intent);
            };
            Handler handler = new Handler();
            int millisDelay = 5000;
            handler.postDelayed(task, delay);

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
//                    Intent intent = new Intent(SplashScreen2.this, LoginActivity.class);
//                    startActivity(intent);
    }
}
//            }, delay);
//        }
//        */
//        }
//    }
