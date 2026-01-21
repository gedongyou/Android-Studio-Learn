package com.example.test3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.test3.utils.DateUtil;

public class ButtonClickActivity extends AppCompatActivity {

    private Button btn;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_click);

        btn = findViewById(R.id.btn);
        textResult = findViewById(R.id.result);

        btn.setOnClickListener(new MyOnclick(textResult));

    }
    static class MyOnclick  implements View.OnClickListener {
        private final TextView textResult;
        public MyOnclick(TextView textResult) {
            this.textResult = textResult;
        }
        @RequiresApi(api = Build.VERSION_CODES.O)
        public void onClick(View v){
            String str = String.format("%s你点击了按钮，%s", DateUtil.getNowTime(),((Button)v).getText());
            textResult.setText(str);
        }
    }

}