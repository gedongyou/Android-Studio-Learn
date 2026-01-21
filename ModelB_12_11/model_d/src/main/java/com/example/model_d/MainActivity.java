package com.example.model_d;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawerLayout;
    private AlertDialog.Builder builder;
    private TextView bar_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_content, new homeFragment())
                .commit();


        drawerLayout = findViewById(R.id.dl);
        ImageView menu_btn = findViewById(R.id.menu_btn);
        menu_btn.setOnClickListener(this);


        LinearLayout tc = findViewById(R.id.tc);
        tc.setOnClickListener(this);
        builder = new AlertDialog.Builder(this);

        findViewById(R.id.btn_wzcx).setOnClickListener(this);
        findViewById(R.id.btn_lkcx).setOnClickListener(this);
        findViewById(R.id.btn_yhgl).setOnClickListener(this);

        bar_text = findViewById(R.id.bar_text);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu_btn:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.btn_wzcx:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_content, new wzcxFragment())
                        .commit();
                bar_text.setText("违章查询");
                break;
            case R.id.btn_lkcx:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_content, new lkcxFragment())
                        .commit();
                bar_text.setText("路况查询");
                break;
            case R.id.btn_yhgl:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_content, new yhglFragment())
                        .commit();
                bar_text.setText("用户管理");
                break;
            case R.id.tc:
                drawerLayout.closeDrawer(GravityCompat.START);
                builder.setTitle("是否退出系统?");
                builder.setPositiveButton("确定", (dialog, which) -> {
                    finish();
                });
                builder.setNegativeButton("取消", ((dialog, which) -> {
                    dialog.dismiss();
                }));
                builder.show();
                break;
        }
    }
}