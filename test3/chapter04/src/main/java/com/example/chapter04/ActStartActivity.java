package com.example.chapter04;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class ActStartActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_start);
        findViewById(R.id.click).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, ActFinishActivity.class));
    }

    
}