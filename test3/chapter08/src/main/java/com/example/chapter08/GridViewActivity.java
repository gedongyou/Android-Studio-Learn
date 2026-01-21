package com.example.chapter08;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import adapter.PlanetGridAdapter;
import bean.Planet;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);


        GridView gv = findViewById(R.id.gv_planet);
        List<Planet> list = Planet.getDefaultList();
        PlanetGridAdapter gridAdapter = new PlanetGridAdapter(this, list);
        gv.setAdapter(gridAdapter);

    }
}