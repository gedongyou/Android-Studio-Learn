package utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

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
