package com.example.secondprototype;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.example.secondprototype.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/*This is the MainActivity
* It displays the tabbed layout consisting of three tab fragments
* The first tab is the Home Tab
* The second tab is the Examples Tab
* The third tab is the Try It tab
* This activity contains code for inflating the tabbed layout
* and for continuously checking the internet connectivity
* */


public class MainActivity extends AppCompatActivity {




    private static final String tag = "MainActivity";
    private SectionPageAdapter mSectionPageAdapter;
    private ViewPager mViewPager;
    boolean isOn = false;
    ActivityMainBinding binding;
    public static final String BroadcastStringForAction = "checkinternet";
    private IntentFilter mIntentFilter;

    public void check(View view)                                                        //onClick method for all grid items
    {
        int tag = Integer.parseInt(view.getTag().toString());
        switch (tag)
        {
            case 1 :
                Intent intent1 = new Intent(this,Tag_1_Activity.class);
                startActivity(intent1);
                break;

            case 2 :
                Intent intent2 = new Intent(this,Tag_2_Activity.class);
                startActivity(intent2);
                break;
            case 3 :
                Intent intent3 = new Intent(this,Tag_3_Activity.class);
                startActivity(intent3);
                break;
            case 4 :
                Intent intent4 = new Intent(this,Tag_4_Activity.class);
                startActivity(intent4);
                break;
            case 5 :
                Intent intent5 = new Intent(this,Tag_5_Activity.class);
                startActivity(intent5);
                break;
            case 6 :
                Intent intent6 = new Intent(this,Tag_6_Activity.class);
                startActivity(intent6);
                break;
            case 7 :
                Intent intent7 = new Intent(this,Tag_7_Activity.class);
                startActivity(intent7);
                break;
            case 8 :
                Intent intent8 = new Intent(this,Tag_8_Activity.class);
                startActivity(intent8);
                break;
            case 9 :
                Intent intent9 = new Intent(this,Tag_9_Activity.class);
                startActivity(intent9);
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {                            //Inflating the layout and setting up the fragments
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        isOn=false;
        setUpPager_Adapter_TabLayout();


        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(BroadcastStringForAction);
        Intent serviceIntent = new Intent(this,MyService.class);
        startService(serviceIntent);


        binding.tvNotconnected.setVisibility(View.GONE);
        if (isOnline(getApplicationContext()))
        {
            Set_Visibility_ON();
        }
        else {
            Set_Visibility_OFF();
        }



    }
    public void setUpPager_Adapter_TabLayout()                                  //Setting the tab layout and view pager
    {
        isOn=true;
        mSectionPageAdapter = new SectionPageAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager)findViewById(R.id.view_pager);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager)                               // Setting up the view pager
    {
        SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), getString(R.string.home_tab));
        adapter.addFragment(new Tab2Fragment(),getString(R.string.examples_tab));
        adapter.addFragment(new Tab3Fragment(),getString(R.string.interactive_tab));
        viewPager.setAdapter(adapter);
    }

    public BroadcastReceiver myReciever = new BroadcastReceiver() {                 // Broadcast service for checking the internet connection
        @Override
        public void onReceive(Context context, Intent intent) {


            if(intent.getAction().equals(BroadcastStringForAction))
            {
                if(intent.getStringExtra("online_status").equals("true"))
                {
                    Set_Visibility_ON();
                    if(isOn==false){
                        setUpPager_Adapter_TabLayout();
                    }
                }
                else
                {
                    Set_Visibility_OFF();
                }
            }
        }
    };

    public boolean isOnline(Context c)                                               //For initial check of internet connection when app first starts
    {
        ConnectivityManager cm = (ConnectivityManager)c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();

        if(ni!=null && ni.isConnectedOrConnecting())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void Set_Visibility_ON()                                                     //Shows regular layout while connected to interet
    {
        binding.tvNotconnected.setVisibility(View.GONE);
        binding.onParentLayout.setVisibility(View.VISIBLE);
        binding.offParentLayout.setVisibility(View.GONE);
    }
    public void Set_Visibility_OFF()                                                      //To show the message when the internet connection is off
    {
        binding.tvNotconnected.setVisibility(View.VISIBLE);
        binding.onParentLayout.setVisibility(View.GONE);
        binding.offParentLayout.setVisibility(View.VISIBLE);
        binding.offParentLayout.setBackgroundColor(Color.GREEN);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        registerReceiver(myReciever,mIntentFilter);                                        // To re-register the reciever when the activity restarts
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myReciever);                                                     //To release the reciever when the onPause() is called
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myReciever,mIntentFilter);                                         //To register the reciever when onResume() is called
    }
}