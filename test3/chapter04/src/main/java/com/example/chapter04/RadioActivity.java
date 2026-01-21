package com.example.chapter04;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RadioActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);


        tv_result = findViewById(R.id.result);

        RadioGroup radio = findViewById(R.id.radioG);

        radio.setOnCheckedChangeListener(this);
    }


    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.man:
                tv_result.setText("你是一个沃尔玛购物袋");
                break;
            case R.id.woman:
                tv_result.setText("你是一个武装直升机");
                break;
        }
    }
}