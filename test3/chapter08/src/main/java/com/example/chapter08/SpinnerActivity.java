package com.example.chapter08;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner drop_down;
    private Spinner dialog;
    private String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        drop_down = findViewById(R.id.drop_down);
        dialog = findViewById(R.id.dialog);
        data = new String[]{"水星", "金星", "地球", "火星", "木星", "土星", "天王星", "海王星"};


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, R.layout.item_select, data);

        drop_down.setAdapter(dataAdapter);
        drop_down.setSelection(1);
        dialog.setAdapter(dataAdapter);
        dialog.setPrompt("选择一个选项");
        dialog.setOnItemSelectedListener(this);
        drop_down.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "你选择了" + data[i], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}