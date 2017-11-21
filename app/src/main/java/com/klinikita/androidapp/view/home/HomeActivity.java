package com.klinikita.androidapp.view.home;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.klinikita.androidapp.R;
import com.klinikita.androidapp.helper.BottomNavigationHelper;
import com.klinikita.androidapp.view.feed.FeedHomeFragment;
import com.klinikita.androidapp.view.history.HistoryHomeFragment;
import com.klinikita.androidapp.view.more.MoreHomeFragment;

public class HomeActivity extends AppCompatActivity {


    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationHelper.disableShiftMode(navigation);

        Fragment newFragment;
        newFragment = MainHomeFragment.newInstance();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, newFragment);
        fragmentTransaction.commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Fragment newFragment;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    newFragment = MainHomeFragment.newInstance();
                    fragmentTransaction.replace(R.id.content, newFragment);
                    fragmentTransaction.commit();
                    return true;
//                    break;
                case R.id.navigation_feed:
                    newFragment = FeedHomeFragment.newInstance();
                    fragmentTransaction.replace(R.id.content, newFragment);
                    fragmentTransaction.commit();
                    return true;
//                    break;
                case R.id.navigation_history:
                    newFragment = HistoryHomeFragment.newInstance();
                    fragmentTransaction.replace(R.id.content, newFragment);
                    fragmentTransaction.commit();
                    return true;
//                    break;
                case R.id.navigation_more:
                    newFragment = MoreHomeFragment.newInstance();
                    fragmentTransaction.replace(R.id.content, newFragment);
                    fragmentTransaction.commit();
                    return true;
//                    break;
            }
            return false;
        }

    };



}
