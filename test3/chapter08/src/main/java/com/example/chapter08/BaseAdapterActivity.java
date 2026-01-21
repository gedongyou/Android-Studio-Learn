package com.example.chapter08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import java.util.List;

import adapter.PlanetBaseAdapter;
import bean.Planet;

public class BaseAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter);

        Spinner sp = findViewById(R.id.dialog);
        List<Planet> list = Planet.getDefaultList();
        PlanetBaseAdapter adapter = new PlanetBaseAdapter(this, list);
        sp.setAdapter(adapter);
    }
}