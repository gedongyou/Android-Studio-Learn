package Util;

import android.content.Context;

public class Utils {
    public static int dip2px(Context context, float dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density + 0.5f);
    }
}
