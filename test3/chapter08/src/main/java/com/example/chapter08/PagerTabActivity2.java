package com.example.chapter08;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import adapter.ImagePagerAdapter;
import bean.GoodsInfo;

public class PagerTabActivity2 extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ArrayList<GoodsInfo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_tab2);

        initTabStrip();
        initViewPager();
    }

    private void initTabStrip() {
        PagerTabStrip pts_tab = findViewById(R.id.pts_tab);
        pts_tab.setTextColor(Color.BLACK);
        pts_tab.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);


    }

    private void initViewPager() {
        ViewPager vp = findViewById(R.id.vp_content);
        list = GoodsInfo.getDefaultList();
        ImagePagerAdapter adapter = new ImagePagerAdapter(this, list);
        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(this);
        vp.setCurrentItem(3, true);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(this, "你选择的是" + list.get(position).name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}