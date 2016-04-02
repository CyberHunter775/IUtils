package com.xin.iutils;

import android.app.Application;

/**
 * Created by Administrator on 2016/4/2.
 */
public class AppContext extends Application {


    private static AppContext appContext;

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = this;
    }

    public static AppContext getContext(){

        return appContext;
    }

}
