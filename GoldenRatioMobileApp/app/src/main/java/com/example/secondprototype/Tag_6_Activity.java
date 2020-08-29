package com.example.secondprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Tag_6_Activity extends AppCompatActivity {

    /*This activity displays thoery for the option with tag 6*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_6_);

        String s1 = "The DNA molecule, the program for all life, is based on the golden section.  It measures 34 angstroms long by 21 angstroms wide for each full cycle of its double helix spiral.34 and 21, of course, are numbers in the Fibonacci series and their ratio, 1.6190476 closely approximates phi, 1.6180339.";
        String s2 = "Golden Ratio can also be observed in the position in which a baby lies in mother's womb and also in our faces and ears.";

        TextView tv1,tv2;
        tv1 = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv1.setText(s1);
        tv2.setText(s2);

    }
}