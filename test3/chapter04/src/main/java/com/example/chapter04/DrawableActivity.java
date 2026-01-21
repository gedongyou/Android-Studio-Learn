package com.example.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DrawableActivity extends AppCompatActivity implements View.OnClickListener {

    private View change_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);


        change_view = findViewById(R.id.change_view);
        Button btn_corn = findViewById(R.id.btn_corn);
        Button btn_oval = findViewById(R.id.btn_oval);
        btn_corn.setOnClickListener(this);
        btn_oval.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_corn:
                change_view.setBackgroundResource(R.drawable.shape_rect_gold);
                break;
            case R.id.btn_oval:
                change_view.setBackgroundResource(R.drawable.shape_oval);
                break;
        }
    }
}