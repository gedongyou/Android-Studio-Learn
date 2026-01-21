package com.example.chapter08;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import adapter.PlanetBaseAdapter;
import bean.Planet;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, CompoundButton.OnCheckedChangeListener {

    private List<Planet> list;
    private ListView lv;
    private CheckBox divider;
    private CheckBox selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        lv = findViewById(R.id.lv);
        list = Planet.getDefaultList();
        PlanetBaseAdapter adapter = new PlanetBaseAdapter(this, list);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(this);


        divider = findViewById(R.id.divider);
        selected = findViewById(R.id.selected);


        divider.setOnCheckedChangeListener(this);
        selected.setOnCheckedChangeListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "你选择的是" + list.get(i).name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.divider:
                if (divider.isChecked()) {
                    Drawable drawable = getResources().getDrawable(R.color.black, getTheme());
                    lv.setDivider(drawable);
                    lv.setDividerHeight(Util.utils.dip2px(this, 1));
                } else {
                    lv.setDivider(null);
                    lv.setDividerHeight(0);
                }
                break;
            case R.id.selected:
                if (selected.isChecked()) {
                    lv.setSelector(R.drawable.list_selector);
                } else {
                    Drawable drawable = getResources().getDrawable(R.color.transparent);
                    lv.setSelector(drawable);
                }
                break;
        }
    }
}