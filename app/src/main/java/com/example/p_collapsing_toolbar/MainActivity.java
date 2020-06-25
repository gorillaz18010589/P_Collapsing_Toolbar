package com.example.p_collapsing_toolbar;
//A_S_Collapsing Toolbar
//API: implementation 'com.android.support:appcompat-v7:29.0.1'
//    implementation 'com.android.support:design:29.0.1'
//1.style/noActionBar
//2.CoordinatorLayout => AppBarLayout => CollapsingToolbarLayout => Toolbar
//3.FloatingActionBar = > NestedScrollView
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
