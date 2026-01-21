package com.example.test3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.test3.utils.DateUtil;

import java.sql.Date;

public class ButtonStyleActivity extends AppCompatActivity {

    private TextView result;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_style);


        result = findViewById(R.id.result);
        layout = findViewById(R.id.bg);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void click(View view) {
        String str =  String.format("%s点击了按钮\"%s\"",DateUtil.getNowTime(),((Button)view).getText());
        result.setText(str);
        Log.d("test111", DateUtil.getNowTime());
    }

    @SuppressLint("ResourceAsColor")
    public void changeBG(View view) {
        layout.setBackgroundColor(Color.parseColor("#00ffaa"));

    }
}