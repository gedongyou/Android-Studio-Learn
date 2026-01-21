package com.example.modelc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import Util.request;
import bean.Register;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_uname;
    private EditText et_passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        et_uname = findViewById(R.id.et_uname);
        et_passwd = findViewById(R.id.et_passwd);
        Button btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (et_passwd.getText().toString().length() >= 8 && et_passwd.getText().toString().length() <= 16) {
            JSONObject data = new JSONObject();
            try {
                data.put("userName", et_uname.getText().toString());
                data.put("phonenumber", et_uname.getText().toString());
                data.put("password", et_passwd.getText().toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            request.post(this, "/prod-api/api/register", data.toString(), result -> {
                Gson gson = new Gson();
                Register reg_data = gson.fromJson(result, Register.class);
                if (reg_data.getCode() == 200) {
                    Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(this, LoginActivity.class);
//                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, reg_data.getMsg(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "密码长度不符合", Toast.LENGTH_SHORT).show();
        }
    }
}