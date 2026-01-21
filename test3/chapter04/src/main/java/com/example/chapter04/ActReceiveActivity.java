package com.example.chapter04;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActReceiveActivity extends AppCompatActivity {

    private TextView tv_receive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_receive);


        tv_receive = findViewById(R.id.tv_receive);
        Bundle bundle = getIntent().getExtras();
        String request_time = bundle.getString("request_time");
        String request_content = bundle.getString("request_content");
        String receive = String.format("发送时间：%s\n发送内容：%s", request_time, request_content);
        tv_receive.setText(receive);

        
    }
}