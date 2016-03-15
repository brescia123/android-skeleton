package com.gbresciani.androidSkeleton.ui.main;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.gbresciani.androidSkeleton.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment) fm.findFragmentByTag("mainFragment");

        // create the fragment and data the first time
        if (mainFragment == null) {
            // add the fragment
            mainFragment = MainFragment.newInstance();
            fm.beginTransaction().add(R.id.mainLayout, mainFragment, "mainFragment").commit();
        }
    }
}
