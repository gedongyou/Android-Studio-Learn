package com.example.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class ActFinishActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_finish);

        findViewById(R.id.btn_back).setOnClickListener(this);
        findViewById(R.id.image_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}