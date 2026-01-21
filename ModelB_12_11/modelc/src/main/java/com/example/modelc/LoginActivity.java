package com.example.modelc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import Util.request;
import Util.request1;
import bean.Login;
import bean.UserInfo;
import bean.user;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView et_uname;
    private TextView et_passwd;
    private SharedPreferences sp;
    private CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_uname = findViewById(R.id.et_uname);
        et_passwd = findViewById(R.id.et_passwd);
        et_uname.setFilters(new InputFilter[]{
                new InputFilter.LengthFilter(11),
                (source, start, end, dest, dstart, dend) -> source.toString().matches("[a-zA-Z0-9]+") ? null : ""
        });

        cb = findViewById(R.id.check);
        Button btn_login = findViewById(R.id.btn_login);
        Button btn_register = findViewById(R.id.btn_register);
        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        sp = getSharedPreferences("login", MODE_PRIVATE);

        if (!sp.getString("SaveUname", "").isEmpty()) {
            et_uname.setText(sp.getString("SaveUname", ""));
            et_passwd.setText(sp.getString("SavePasswd", ""));
        }


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
//                Toast.makeText(this, "点击了按钮", Toast.LENGTH_SHORT).show();
                JSONObject params = new JSONObject();
                try {
                    params.put("username", et_uname.getText().toString());
                    params.put("password", et_passwd.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                request.post(this, "/prod-api/api/login", params.toString(), result -> {
                    Gson gson = new Gson();
                    Login login_data = gson.fromJson(result, Login.class);

                    if (login_data.getCode() == 200 && login_data.getToken() != null) {
                        sp.edit()
                                .putString("token", login_data.getToken())
                                .apply();
                        if (cb.isChecked()) {
                            sp.edit()
                                    .putString("SaveUname", et_uname.getText().toString())
                                    .putString("SavePasswd", et_passwd.getText().toString())
                                    .apply();
                        }
                        request1.get(this, "/prod-api/api/common/user/getInfo", result1 -> {
                            UserInfo info = gson.fromJson(result1, UserInfo.class);
                            user user = info.getAcwUser();
                            Toast.makeText(this, user.getRealName() + "欢迎登录", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(this, cxpjActivity.class);
                            startActivity(intent);
                        });

                    } else {
                        et_passwd.setText("");
                        Toast.makeText(this, login_data.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                });

                break;
            case R.id.btn_register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}