package com.example.test3;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_result;
    private String firstNUm = "0";
    private String operator = "";
    private String secondNum = "";
    private String result = "";
    private String showText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);


        tv_result = findViewById(R.id.result);
        tv_result.setMovementMethod(new ScrollingMovementMethod());
        findViewById(R.id.btn_ce).setOnClickListener(this);
        findViewById(R.id.btn_Divided).setOnClickListener(this);//除号
        findViewById(R.id.btn_Times).setOnClickListener(this);//乘号
        findViewById(R.id.btn_c).setOnClickListener(this);//清除
        findViewById(R.id.btn_7).setOnClickListener(this);//7
        findViewById(R.id.btn_8).setOnClickListener(this);//8
        findViewById(R.id.btn_9).setOnClickListener(this);//9
        findViewById(R.id.btn_plus).setOnClickListener(this);//加号
        findViewById(R.id.btn_4).setOnClickListener(this);//4
        findViewById(R.id.btn_5).setOnClickListener(this);//5
        findViewById(R.id.btn_6).setOnClickListener(this);//6
        findViewById(R.id.btn_minus).setOnClickListener(this);//减号
        findViewById(R.id.btn_1).setOnClickListener(this);//1
        findViewById(R.id.btn_2).setOnClickListener(this);//2
        findViewById(R.id.btn_3).setOnClickListener(this);//3
        findViewById(R.id.btn_square).setOnClickListener(this);//根号
        findViewById(R.id.btn_1_x).setOnClickListener(this);//倒数
        findViewById(R.id.btn_0).setOnClickListener(this);//0
        findViewById(R.id.btn_dian).setOnClickListener(this);//.
        findViewById(R.id.btn_den).setOnClickListener(this);//=


    }

    @Override
    public void onClick(View view) {
        String inputText;
        if (view.getId() == R.id.btn_square) {
            inputText = "√";
        } else {
            inputText = ((TextView) view).getText().toString();
        }

        switch (view.getId()) {
            case R.id.btn_c:
                clear();
                break;
            case R.id.btn_ce:
                break;
            case R.id.btn_plus:
            case R.id.btn_minus:
            case R.id.btn_Times:
            case R.id.btn_Divided:
                if (!operator.equals("")) {
                    double calcResult = calcFour();
                    refreshOperate(String.valueOf(calcResult));
                    refreshText(showText + "=" + calcResult);
                }
                operator = inputText;
                refreshText(showText + operator);
                break;
            case R.id.btn_den:
                double calcResult = calcFour();
                refreshOperate(String.valueOf(calcResult));
                if (calcResult != 0) {
                    refreshText(showText + "=" + calcResult);
                } else {
                    clear();
                }

                break;
            case R.id.btn_square:
                double sqrt_result = Math.sqrt(Double.parseDouble(firstNUm));
                refreshOperate(String.valueOf(sqrt_result));
                refreshText(showText + "√=" + sqrt_result);
                break;
            case R.id.btn_1_x:
                double reciprocalResult = 1.0 / Double.parseDouble(firstNUm);
                refreshOperate(String.valueOf(reciprocalResult));
                refreshText(showText + "/=" + reciprocalResult);
                break;
            default:
                if (result.length() > 0 && operator.equals("")) {
                    clear();
                }
                if (operator.equals("")) {
                    firstNUm = firstNUm + inputText;
                } else {
                    secondNum = secondNum + inputText;
                }
                if (showText.equals("0") && !inputText.equals(".")) {
                    refreshText(inputText);
                } else {
                    refreshText(showText + inputText);
                }
        }
    }

    //四则运算返回计算结果
    private double calcFour() {
        switch (operator) {
            case "+":
                return Double.parseDouble(firstNUm) + Double.parseDouble(secondNum);
            case "-":
                return Double.parseDouble(firstNUm) - Double.parseDouble(secondNum);
            case "×":
                return Double.parseDouble(firstNUm) * Double.parseDouble(secondNum);
            case "÷":
                return Double.parseDouble(firstNUm) / Double.parseDouble(secondNum);
        }
        return 0;
    }

    //清空并重置
    private void clear() {
        refreshText("0");
        refreshOperate("");
    }

    //重置运算结果
    private void refreshOperate(String new_result) {
        result = new_result;
        firstNUm = result;
        secondNum = "";
        operator = "";
    }

    //刷新内容
    private void refreshText(String text) {
        showText = text;
        tv_result.setText(showText);
    }
}