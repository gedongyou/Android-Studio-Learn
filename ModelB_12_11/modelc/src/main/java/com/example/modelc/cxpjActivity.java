package com.example.modelc;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.time.LocalDate;

import Adapter.bannerAdapter;

public class cxpjActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TextWatcher {

    private EditText date_picker;
    private EditText et_from;
    private EditText et_to;
    private SharedPreferences sp;
    private boolean SetText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cxpj);

        Button btn_search = findViewById(R.id.btn_search);
        btn_search.setOnClickListener(this);
        et_from = findViewById(R.id.et_from);
        et_to = findViewById(R.id.et_to);
        et_from.addTextChangedListener(this);
        et_to.addTextChangedListener(this);


        date_picker = findViewById(R.id.date_picker);
        date_picker.setOnClickListener(this);

        ViewPager vp = findViewById(R.id.vp);

        int[] imgArr = {R.drawable.gril, R.drawable.star, R.drawable.wallhaven};
        bannerAdapter adapter = new bannerAdapter(this, imgArr);
        vp.setAdapter(adapter);
        sp = getSharedPreferences("data", MODE_PRIVATE);

        if (!sp.getString("to", "").isEmpty()) {
            SetText = true;
            et_from.setText(sp.getString("form", ""));
            et_to.setText(sp.getString("to", ""));
            SetText = false;
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.date_picker:
                LocalDate date = LocalDate.now();
                DatePickerDialog dialog = new DatePickerDialog(this, this, date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth());
                dialog.show();
                break;
            case R.id.btn_search:
                if (et_from.getText().toString().isEmpty() || et_to.getText().toString().isEmpty() || date_picker.getText().toString().isEmpty()) {
                    Toast.makeText(this, "请补充完整信息", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(this, jplbActivity.class);
                    intent.putExtra("start", et_from.getText().toString());
                    intent.putExtra("end", et_to.getText().toString());
                    intent.putExtra("date", date_picker.getText().toString());

                    startActivity(intent);
                }
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String str = String.format("%s年%s月%s日", year, month + 1, dayOfMonth);
        date_picker.setText(str);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        if (SetText) return;
//        Toast.makeText(this, "输入内容：" + et_from.getText().toString() + et_to.getText().toString(), Toast.LENGTH_SHORT).show();
        sp.edit()
                .putString("form", et_from.getText().toString())
                .putString("to", et_to.getText().toString())
                .putString("Date", date_picker.getText().toString())
                .apply();
    }
}