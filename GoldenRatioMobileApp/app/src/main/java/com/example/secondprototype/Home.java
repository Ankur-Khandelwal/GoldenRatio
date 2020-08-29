package com.example.secondprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;                                  //Setting the time of opening screen to 2 seconds
    ImageView imageView;                                                        //To display the logo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.animate().scaleY(3f).scaleX(3f).setDuration(1800);           //Adding the zoom in animation to logo



        new Handler().postDelayed(new Runnable(){                              //Setting the timer to 2 seconds to start main activity after app starts
            @Override
            public void run() {
                Intent mainActivityIntent = new Intent(Home.this,MainActivity.class);
                startActivity(mainActivityIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}