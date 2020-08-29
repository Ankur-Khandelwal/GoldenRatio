package com.example.secondprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Tag_5_Activity extends AppCompatActivity {

    /*This activity displays thoery for the option with tag 5*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_5_);

        String s1 = "As a matter of fact, our brains are seemingly hard-wired to prefer objects and images that use the Golden Ratio. It’s almost a subconscious attraction and even tiny tweaks that make an image truer to the Golden Ratio have a large impact on our brains.";
        String s2 = "It is well known that the eyes take in information more efficiently when they scan side to side, as opposed to up and down. When you look at what so many people have been drawing and building, you see these proportions everywhere.";

        TextView tv1,tv2;
        tv1 = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv1.setText(s1);
        tv2.setText(s2);
    }
}