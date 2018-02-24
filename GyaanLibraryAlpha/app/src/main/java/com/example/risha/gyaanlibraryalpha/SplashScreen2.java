package com.example.risha.gyaanlibraryalpha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Random;

public class SplashScreen2 extends AppCompatActivity {

    int percent = 0;
    //    TextView percentText;
    int randomInt;
    int delay;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);

        textView = findViewById(R.id.textView);
        //Toast.makeText(this, "Splash Screen2", Toast.LENGTH_SHORT).show();

        final Random random = new Random();
        while (percent < 100) {
//            Runnable task = new Runnable() {
//                public void run() {
                    // Execute your delayed code
                    randomInt = random.nextInt(3) + 2;
                    percent += randomInt;
                    textView.setText(String.valueOf(percent));
                    Random randDelay = new Random();
                    delay = randDelay.nextInt(1000) + 750;
                }

        Intent intent = new Intent(SplashScreen2.this, LoginActivity.class);
        startActivity(intent);
//            };
//            Handler handler = new Handler();
//            int millisDelay = 5000;
//            handler.postDelayed(task, delay);
//
//            try {
//                Thread.sleep(delay);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//                    Intent intent = new Intent(SplashScreen2.this, LoginActivity.class);
//                    startActivity(intent);
//                }
//            }, delay);
//        }
    }
}
