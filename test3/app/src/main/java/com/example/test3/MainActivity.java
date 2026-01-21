package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn =  findViewById(R.id.tz);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("test", "onClick: 121");
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        TextView text =  findViewById(R.id.hzl);
        text.setTextSize(30);


        ValueAnimator  time = ValueAnimator.ofObject(
                new ArgbEvaluator(),
                Color.parseColor("#FF5252"), // 红
                Color.parseColor("#FFEB3B"), // 黄
                Color.parseColor("#4CAF50"), // 绿
                Color.parseColor("#2196F3"), // 蓝
                Color.parseColor("#FF5252")
        );
        time.setDuration(600);
        time.setRepeatCount(ValueAnimator.INFINITE);
        time.setRepeatMode(ValueAnimator.RESTART);
        time.addUpdateListener(anim -> {
            int color = (int) anim.getAnimatedValue();
            text.setTextColor(color);    // 更新文字颜色
        });
        time.start();
    }
}