package com.example.chapter04;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import utils.DateUtil;

public class ActRequestActivity extends AppCompatActivity implements View.OnClickListener {

    private String sendMsg = "hzl是帅比吗";
    private ActivityResultLauncher<Intent> register;
    private TextView tv_response;
    private TextView tv_request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_request);

        tv_request = findViewById(R.id.tv_request);
        tv_response = findViewById(R.id.tv_response);
        tv_request.setText("要发送的数据为：" + sendMsg);
        findViewById(R.id.btn_request).setOnClickListener(this);

        register = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result != null) {
                Intent intent = result.getData();
                if (intent != null && result.getResultCode() == Activity.RESULT_OK) {
                    Bundle bundle = intent.getExtras();
                    String response_time = bundle.getString("response_time");
                    String response_content = bundle.getString("response_content");
                    String format = String.format("收到信息：%s,%s", response_time, response_content);
                    tv_response.setText(format);
                }

            }

        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ActResponseActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("request_time", DateUtil.getNowTime());
        bundle.putString("request_content", sendMsg);
        intent.putExtras(bundle);

        register.launch(intent);
    }
}