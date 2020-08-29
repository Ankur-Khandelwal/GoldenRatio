package com.example.secondprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Tag_8_Activity extends AppCompatActivity {

    /*This activity displays thoery for the option with tag 8*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_8_);

        String s1 = "The dimensions of the Earth and Moon are in Phi relationship, forming a Triangle based on 1.618.This triangle is known as a Kepler triangle. This geometric construction is the same as that which appears to have been used in the construction of the Great Pyramid of Egypt.";
        String s2 = "The diameter of Saturn is very close to a phi relationship with the diameter of its rings. The inner ring division is in a relationship that is very close to phi with the diameter of the rings outside the sphere of the planet. The Cassini division in the rings of Saturn falls at the Golden Section of the width of the lighter outside section of the rings.";
        TextView tv1,tv2,tv3;
        tv1 = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv1.setText(s1);
        tv2.setText(s2);

    }
}