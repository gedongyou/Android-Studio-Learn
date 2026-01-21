package com.example.modelb_12_11;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import Adapter.SplashViewAdapter;
import Util.Utils;

public class SplashViewActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private int[] imgArr;
    private String[] contentArr;
    private RadioGroup sp_radio;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_view);


        imgArr = new int[]{R.drawable.splash1, R.drawable.splash2, R.drawable.splash3};
        contentArr = new String[]{"刷码乘车，行业领先", "内置商城，专享优惠", "视觉优化，全新体验"};
        sp_radio = findViewById(R.id.sp_radio);
        vp = findViewById(R.id.vp_splash);


        for (int j = 0; j < imgArr.length; j++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setButtonDrawable(null);
            radioButton.setBackgroundResource(R.drawable.radio_btn);

            ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(
                    Utils.dip2px(this, 20),
                    Utils.dip2px(this, 20)
            );
            params.setMargins(Utils.dip2px(this, 30), 0, Utils.dip2px(this, 30), 0);
            sp_radio.addView(radioButton, params);
        }

        SplashViewAdapter adapter = new SplashViewAdapter(this, imgArr, contentArr);
        vp.setAdapter(adapter);


        sp_radio.setOnCheckedChangeListener(this);
        ((RadioButton) sp_radio.getChildAt(0)).setChecked(true);
        vp.addOnPageChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        vp.setCurrentItem(i - 1);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        ((RadioButton) sp_radio.getChildAt(position)).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


}