package it.gbresciani.androidSkeleton.ui.main;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(it.gbresciani.androidSkeleton.R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        MainFragment mainFragment = (MainFragment) fm.findFragmentByTag("mainFragment");

        // create the fragment and data the first time
        if (mainFragment == null) {
            // add the fragment
            mainFragment = MainFragment.newInstance();
            fm.beginTransaction().add(it.gbresciani.androidSkeleton.R.id.mainLayout, mainFragment, "mainFragment").commit();
        }
    }
}
