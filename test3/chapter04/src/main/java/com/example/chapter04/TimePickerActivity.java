package com.example.chapter04;

import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class TimePickerActivity extends AppCompatActivity implements View.OnClickListener, TimePickerDialog.OnTimeSetListener {

    private TextView tv_result;
    private TimePicker tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);

        findViewById(R.id.btn_confirm).setOnClickListener(this);
        findViewById(R.id.btn_time_picker).setOnClickListener(this);

        tp = findViewById(R.id.tp);
        tv_result = findViewById(R.id.tv_result);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
                String str = String.format("你选择的时间为%s：%s", tp.getHour(), tp.getMinute());
                tv_result.setText(str);
                break;
            case R.id.btn_time_picker:
                Calendar calendar = Calendar.getInstance();
                TimePickerDialog time = new TimePickerDialog(this, this, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
                time.create();
                time.show();
        }
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        String str = String.format("你选择的时间为%s：%s", i, i1);
        tv_result.setText(str);
    }
}