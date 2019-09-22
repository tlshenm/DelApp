package com.sishin.phone.delapp;

import android.app.Application;
import android.content.Context;

public class DelAppApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getAppContext(){
        return mContext;
    }
}
