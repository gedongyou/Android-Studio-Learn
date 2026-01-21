package com.example.test3.utils;

import android.content.Context;
import android.util.Log;

import static androidx.constraintlayout.widget.StateSet.TAG;

public class utils {
    public static int dip2px (Context Context,float dpValue){
        float scale = Context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale +0.5f);
    }
}
