package com.example.modelb_12_11;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import Adapter.SplashView2Adapter;

public class SplashView2Activity extends AppCompatActivity {

    private int[] imgArr;
    private String[] contentArr;
    private TabLayout tabLayout;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_view2);

        imgArr = new int[]{R.drawable.splash1, R.drawable.splash2, R.drawable.splash3};
        contentArr = new String[]{"刷码乘车，行业领先", "内置商城，专享优惠", "视觉优化，全新体验"};
        tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 vp = findViewById(R.id.sp_vp);
        SplashView2Adapter adapter = new SplashView2Adapter(this, imgArr, contentArr);
        vp.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, vp,
                (tab, position) -> {
                    tab.setCustomView(R.drawable.dot_selecter);
                }).attach();


    }
}