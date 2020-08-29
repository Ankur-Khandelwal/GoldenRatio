package com.example.secondprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Tag_3_Activity extends AppCompatActivity {

    /*This activity displays thoery for the option with tag 3*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_3_);

        String s1 = "This harmony and proportion has been recognized for thousands of centuries: from the Pyramids in Giza to the Parthenon in Athens; from Michelangelo’s The Creation of Adam on the ceiling of the Sistine Chapel to Da Vinci’s Mona Lisa; and from the Pepsi logo to the The definition of Golden Ratio. ";
        String s2 = "Even our bodies and faces follow the mathematical ratio.";

        TextView tv1,tv2;
        tv1 = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv1.setText(s1);
        tv2.setText(s2);
    }
}