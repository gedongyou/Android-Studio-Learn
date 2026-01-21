package com.example.modelc;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;

import Adapter.ListViewAdapter;
import Util.Utils;
import Util.request1;
import bean.Result;
import bean.xl_data;

public class jplbActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView lv;
    private List<xl_data> rows;
    private ListViewAdapter adapter;
    private int sort1 = 0;
    private int sort2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jplb);
        lv = findViewById(R.id.lv);
        TextView btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);

        String start = getIntent().getStringExtra("start");
        String end = getIntent().getStringExtra("end");
        String date = getIntent().getStringExtra("date");

        TextView tv_start = findViewById(R.id.start);
        TextView tv_end = findViewById(R.id.end);
        TextView tv_date = findViewById(R.id.date);
        tv_start.setText(start);
        tv_end.setText(end);
        tv_date.setText("日期：" + date);

        LinearLayout time_sort = findViewById(R.id.time_sort);
        LinearLayout price_sort = findViewById(R.id.price_sort);


        time_sort.setOnClickListener(this);
        price_sort.setOnClickListener(this);


        request1.get(this, "/prod-api/api/bus/line/list", result -> {
            Gson gson = new Gson();
            Type type = new TypeToken<Result<xl_data>>() {
            }.getType();
            Result<xl_data> data = gson.fromJson(result, type);
            rows = data.getRows();

            adapter = new ListViewAdapter(this, rows);
            lv.setAdapter(adapter);
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.price_sort:
                if (sort1 % 2 == 0) {
                    rows.sort(new Comparator<xl_data>() {
                        @Override
                        public int compare(xl_data o1, xl_data o2) {
                            return Double.compare(Double.parseDouble(o2.getPrice()), Double.parseDouble(o1.getPrice()));
                        }
                    });
                } else {
                    rows.sort(new Comparator<xl_data>() {
                        @Override
                        public int compare(xl_data o1, xl_data o2) {
                            return Double.compare(Double.parseDouble(o1.getPrice()), Double.parseDouble(o2.getPrice()));
                        }
                    });
                }
                sort1++;
                adapter.notifyDataSetChanged();
                break;

            case R.id.time_sort:
                if (sort2 % 2 == 0) {
                    rows.sort(new Comparator<xl_data>() {
                        @RequiresApi(api = Build.VERSION_CODES.O)
                        @Override
                        public int compare(xl_data o1, xl_data o2) {
                            LocalTime t1 = LocalTime.parse(Utils.TimeFormat(o1.getStartTime()));
                            LocalTime t2 = LocalTime.parse(Utils.TimeFormat(o2.getStartTime()));

                            return t1.compareTo(t2);
                        }
                    });
                } else {
                    rows.sort(new Comparator<xl_data>() {
                        @RequiresApi(api = Build.VERSION_CODES.O)
                        @Override
                        public int compare(xl_data o1, xl_data o2) {
                            LocalTime t1 = LocalTime.parse(Utils.TimeFormat(o1.getStartTime()));
                            LocalTime t2 = LocalTime.parse(Utils.TimeFormat(o2.getStartTime()));

                            return t2.compareTo(t1);
                        }
                    });
                }
                sort2++;
                adapter.notifyDataSetChanged();
                break;
        }
    }

}