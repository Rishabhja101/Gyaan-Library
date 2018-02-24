package com.example.risha.gyaanlibraryalpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SplashScreen extends Activity {

    int percent = 0;
//    TextView percentText;
    int randomInt;
    int delay;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        textView = findViewById(R.id.textView);
        Toast.makeText(getApplicationContext(), "Splash Screen", Toast.LENGTH_SHORT).show();

        final Random random = new Random();
        while (percent < 100) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    randomInt = random.nextInt(3) + 2;
                    percent += randomInt;
                    textView.setText(String.valueOf(randomInt));

                    Random randDelay = new Random();
                    delay = randDelay.nextInt(2000) + 750;
                    Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                    startActivity(intent);
                }
            }, delay);
        }
    }
}
