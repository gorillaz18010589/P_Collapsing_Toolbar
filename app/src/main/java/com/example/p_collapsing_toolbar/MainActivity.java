package com.example.p_collapsing_toolbar;
//A_S_Collapsing Toolbar
//API: implementation 'com.android.support:appcompat-v7:29.0.1'
//    implementation 'com.android.support:design:29.0.1'
//1.style/noActionBar
//2.CoordinatorLayout => AppBarLayout => CollapsingToolbarLayout => Toolbar
//3.FloatingActionBar = > NestedScrollView
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<User> users;
    private AppBarLayout appBarLayout;
    private boolean shouldScroll;
    private NestedScrollView nestedScrollView;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tvText);
        nestedScrollView = findViewById(R.id.sc);
        appBarLayout = findViewById(R.id.appBar);
        recyclerView = findViewById(R.id.recyview);
        users = new ArrayList<>();
        User user = new User("hank","fuckyour","32");
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new UserRecyclerViewAdapter(users));


        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                int tvHeight = tv.getHeight();
                Log.v("hank","NestedScrollView:" + "x:" +scrollX +"/y:" +scrollX +"oldX:" + oldScrollX +"/oldY:" + oldScrollY +"tv高：" + tvHeight);
                if(oldScrollY == tvHeight)
                {

                    Log.v("hank","到達主要內容的底部停止" + oldScrollY + "/" +tvHeight);

                }
            }
        });

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
              Log.v("hank","onOffsetChanged:" +i);
              if(i == -340){
                  Log.v("hank","停:" +i);
              }

            }
        });


        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                Log.v("hank","onTouchEvent" +e);
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.v("hank","onScrolled:" + dx +":/" + dy);

            }
        });
    }
}
