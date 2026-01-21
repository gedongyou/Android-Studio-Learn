package com.example.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AlertActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        tv_result = findViewById(R.id.tv_result);
        findViewById(R.id.btn_alert).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("黄泽霖是帅比吗");
        builder.setMessage("请选择其中一个选项");
        builder.setPositiveButton("是", (dialogInterface, i) -> {
            tv_result.setText("hzl是大帅比");
        });
        builder.setNegativeButton("不是", (dialogInterface, i) -> {
            tv_result.setText("hzl不是大帅比");
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}