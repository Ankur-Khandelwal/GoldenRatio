package com.example.secondprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Tag_7_Activity extends AppCompatActivity {

    /*This activity displays thoery for the option with tag 7*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_7_);
        String s1 = "One can observe the presence of golden ratio in various animals.The eye, fins and tail all fall at golden sections of the length of a dolphin’s body. The dimensions of the dorsal fin are golden sections. The thickness of the dolphin’s tail section corresponds to same golden section of the line from head to tail.";
        String s2 = "The body sections of an ant are defined by the golden sections of its length. Its leg sections are also golden sections of its length.";
        String s3 = " Some people also observe golden ratio in Ram's horn";
        TextView tv1,tv2,tv3;
        tv1 = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv3 = (TextView)findViewById(R.id.textView3);
        tv1.setText(s1);
        tv2.setText(s2);
        tv3.setText(s3);
    }
}