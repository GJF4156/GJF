package com.flj.latte.ui.dimen;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.util.Objects;

public class ScreenUtils {
    public static int getScreenWidth(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Objects.requireNonNull(manager).getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Objects.requireNonNull(manager).getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
    }
}