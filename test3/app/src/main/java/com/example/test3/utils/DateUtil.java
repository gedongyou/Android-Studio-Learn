package com.example.test3.utils;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateUtil {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String getNowTime(){
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:dd:ss");
//        return sdf.format(new Date());
        LocalTime dt = LocalTime.now();
        return String.valueOf(dt);
    }
}
