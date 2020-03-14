package com.example.mvp;

import android.app.Application;

import org.xutils.x;

public class UtilApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}
