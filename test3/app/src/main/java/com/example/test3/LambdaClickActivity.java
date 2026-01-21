package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LambdaClickActivity extends AppCompatActivity {

    private Button btn;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lambda_click);
        btn = findViewById(R.id.btn);
        result = findViewById(R.id.result);
        btn.setOnClickListener(v->{
            result.setText("点击了按钮");
        });
        btn.setOnLongClickListener(v->{
            result.setText("长按了按钮");
            return true;
        });
    }
}