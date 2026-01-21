package com.example.chapter04;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import utils.DateUtil;

public class ActResponseActivity extends AppCompatActivity implements View.OnClickListener {
    private String responseMsg = "hzl是sb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_response);

        TextView tv_result = findViewById(R.id.tv_request);

        Bundle bundle = getIntent().getExtras();
        String request_time = bundle.getString("request_time");
        String request_content = bundle.getString("request_content");
        String format = String.format("收到信息：%s,%s", request_time, request_content);
        tv_result.setText(format);

        findViewById(R.id.btn_response).setOnClickListener(this);

        TextView tv_response = findViewById(R.id.tv_response);
        tv_response.setText("待返回的消息为:" + responseMsg);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("response_time", DateUtil.getNowTime().toString());
        bundle.putString("response_content", responseMsg);
        Intent intent = new Intent(this, ActRequestActivity.class);
        intent.putExtras(bundle);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}