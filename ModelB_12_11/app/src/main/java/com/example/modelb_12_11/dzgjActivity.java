package com.example.modelb_12_11;

import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalTime;

public class dzgjActivity extends AppCompatActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {

    private LocalTime time;
    private TimePickerDialog pickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dzgj);

        LinearLayout tv_start = findViewById(R.id.startTime);
        LinearLayout tv_back = findViewById(R.id.backTime);
        Button btn_tj = findViewById(R.id.tj);

        tv_start.setOnClickListener(this);
        tv_back.setOnClickListener(this);
        btn_tj.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startTime:
                time = LocalTime.now();
                pickerDialog = new TimePickerDialog(this, this, time.getHour(), time.getMinute(), true);
                pickerDialog.show();
                break;
            case R.id.backTime:
                pickerDialog.show();
                break;
            case R.id.tj:
                Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {

    }
}