package com.example.secondprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Tag_2_Activity extends AppCompatActivity {

    /*This activity displays thoery for the option with tag 2*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_2_);

        String s1 = "The Golden Ratio (also known as the Golden Section, Golden Mean, Divine Proportion or Greek letter Phi) exists when a line is divided into two parts and the longer part (a) divided by the smaller part (b) is equal to the sum of (a) + (b) divided by (a), which both equal 1.618.";
        String s2 = "But don’t let all the math get you down. In design, the Golden Ratio boils down to aesthetics— creating and appreciating a sense of beauty through harmony and proportion. When applied to design, the Golden Ratio provides a sense of artistry; an X-factor; a certain je ne sais quoi.";

        TextView tv1,tv2;
        tv1 = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv1.setText(s1);
        tv2.setText(s2);
    }
}