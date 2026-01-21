package utils;

import android.content.Context;

public class utils {
    public static int dip2px (Context Context,float dpValue){
        float scale = Context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale +0.5f);
    }
}
