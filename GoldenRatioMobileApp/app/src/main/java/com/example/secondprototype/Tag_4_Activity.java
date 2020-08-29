package com.example.secondprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Tag_4_Activity extends AppCompatActivity {

    /*This activity displays thoery for the option with tag 4*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_4_);

        String s1 = "The Fibonacci sequence is 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, etc., with each number being the sum of the previous two.The ratio of each successive pair of numbers in the Fibonacci Sequence converge on the golden ratio as you go higher in the sequence.";
        String s2 = "To fifteen places GR is 1.61803398874989. So in the sequence above, you can see that the ratio from each pair of numbers gets closer and closer to the golden ratio.";

        TextView tv1,tv2;
        tv1 = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv1.setText(s1);
        tv2.setText(s2);
    }
}