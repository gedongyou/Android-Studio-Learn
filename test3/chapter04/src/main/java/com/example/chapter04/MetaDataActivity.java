package com.example.chapter04;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MetaDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meta_data);


        TextView tv_resource = findViewById(R.id.tv_resource);

        PackageManager pm = getPackageManager();

        try {
            ActivityInfo info = pm.getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Bundle bundle = info.metaData;
            String str = bundle.getString("weather_str");
            tv_resource.setText(str);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }


    }
}