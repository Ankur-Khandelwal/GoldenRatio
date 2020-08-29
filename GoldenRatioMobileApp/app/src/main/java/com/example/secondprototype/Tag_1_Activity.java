package com.example.secondprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Tag_1_Activity extends AppCompatActivity {

    /*This activity displays thoery for the option with tag 1*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_1_);

        String s1 = "What do the Pyramids of Giza and Da Vinci’s Mona Lisa have in common with Twitter and Pepsi?\n\nQuick answer: THEY ALL ARE DESIGNED USING GOLDEN RATIO.";
        String s2 = "The Golden Ratio is a mathematical ratio. It is commonly found in nature, and when used in a design, it fosters organic and natural-looking compositions that are aesthetically pleasing to the eye.";

        TextView tv1,tv2;
        tv1 = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv1.setText(s1);
        tv2.setText(s2);

    }


}