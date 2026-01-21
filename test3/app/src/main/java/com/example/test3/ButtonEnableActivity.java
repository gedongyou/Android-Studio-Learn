package com.example.test3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.test3.utils.DateUtil;

public class ButtonEnableActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_enable);

        Button enable = findViewById(R.id.enable);
        Button disable = findViewById(R.id.disable);
        Button testBtn  = findViewById(R.id.testBtn);
        TextView result  = findViewById(R.id.result);


        enable.setOnClickListener(v->{
            testBtn.setEnabled(true);
            result.setText("点击了启用按钮");
        });
        disable.setOnClickListener(v->{
            testBtn.setEnabled(false);
            result.setText("点击了禁用按钮");
        });
        testBtn.setOnClickListener(v->{
            String str = String.format("%s点击了%s", DateUtil.getNowTime(),((Button)v).getText());
            result.setText(str);
        });

    }

}