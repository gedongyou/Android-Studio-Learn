package com.example.chapter04;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class DatePickerActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private DatePicker datePicker;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        datePicker = findViewById(R.id.date_picker);
        tv_result = findViewById(R.id.tv_result);
        findViewById(R.id.btn_confirm).setOnClickListener(this);
        findViewById(R.id.btn_date_picker).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_confirm:
                String str = String.format("你选择的时间为%s年%s月%s日", datePicker.getYear(), datePicker.getMonth() + 1, datePicker.getDayOfMonth());
                tv_result.setText(str);
                break;
            case R.id.btn_date_picker:
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int months = calendar.get(Calendar.MONTH);
                int date = calendar.get(Calendar.DATE);
                DatePickerDialog date_picker_dialog = new DatePickerDialog(this, this, year, months, date);

                date_picker_dialog.create();
                date_picker_dialog.show();
                break;

        }

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        String str = String.format("你选择的时间为%s年%s月%s日", i, i1, i2);
        tv_result.setText(str);
    }
}