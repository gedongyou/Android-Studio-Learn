package com.example.chapter04;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditFocusActivity extends AppCompatActivity implements View.OnFocusChangeListener {

    private EditText et_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_focus);

        et_phone = findViewById(R.id.et_phone);
        EditText et_passwd = findViewById(R.id.et_password);

        et_passwd.setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View view, boolean b) {

        String phone = et_phone.getText().toString();
        if (TextUtils.isEmpty(phone) || phone.length() < 11) {
            et_phone.requestFocus();
            Toast.makeText(this, "请输入11位手机号", Toast.LENGTH_SHORT).show();
        }
    }
}