package com.bruce.accessibility;

import android.app.Application;

import com.orhanobut.logger.Logger;

/**
 * Created by Bruce on 2017/3/9.
 */
public class MApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init("Bruce");
    }
}
