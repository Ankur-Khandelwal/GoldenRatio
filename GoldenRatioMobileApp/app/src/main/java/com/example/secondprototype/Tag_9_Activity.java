package com.example.secondprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Tag_9_Activity extends AppCompatActivity {

    /*This activity displays thoery for the option with tag 9*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_9_);

        String s1 = "Analysts use the Golden Ratio numbers to analyze the support and resistance of stock prices, referring to it as Fibonacci Time Zones, Retracements, Arcs and Fans. When plotting these numbers on a chart, analysts include a low number of 0 percent and a high number of 100 percent. ";
        String s2 = " The support level is when the price of stock should stop decreasing and the resistance is when the stock price should stop increasing. The theory behind this application is that once a stock experiences a significant price increase or decrease, its resistance and support levels will be at or near the Golden Ratio numbers";
        TextView tv1,tv2,tv3;
        tv1 = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv1.setText(s1);
        tv2.setText(s2);
    }
}