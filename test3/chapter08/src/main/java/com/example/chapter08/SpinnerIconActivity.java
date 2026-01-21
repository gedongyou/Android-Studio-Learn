package com.example.chapter08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpinnerIconActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int[] iconArr = {R.drawable.hzl1, R.drawable.hzl2, R.drawable.zz};
    String[] nameArr = {"hzl1", "hzl2", "gdy"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_icon);


        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < iconArr.length; i++) {
            Map data = new HashMap();
            data.put("icon", iconArr[i]);
            data.put("name", nameArr[i]);
            list.add(data);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list, R.layout.item_simple, new String[]{"icon", "name"}, new int[]{R.id.listImg, R.id.listName});

        Spinner drop_down = findViewById(R.id.drop_down);
        Spinner dialog = findViewById(R.id.dialog);
        drop_down.setAdapter(simpleAdapter);
        dialog.setAdapter(simpleAdapter);

        dialog.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "你选择了" + nameArr[i], Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}