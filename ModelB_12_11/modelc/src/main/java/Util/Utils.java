package Util;

public class Utils {
    public static String TimeFormat(String time) {
        String[] parts = time.split(":");
        if (parts[0].length() == 1) {
            parts[0] = "0" + parts[0];
        }
        return parts[0] + ":" + parts[1];
    }
}

