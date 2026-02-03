package Util;

import android.content.Context;

public class Utils {
    public static int dp2px(Context context, float dp) {
        float ds = context.getResources().getDisplayMetrics().density;
        return (int) (dp * ds + 0.5f);
    }
}
