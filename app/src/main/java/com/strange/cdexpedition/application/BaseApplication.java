package com.strange.cdexpedition.application;

import android.app.Application;

import org.xutils.x;

/**
 * Created by AngerYman on 2017/3/10.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
