package com.sishin.phone.delapp.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.sishin.phone.delapp.DelAppApplication;

public class SharedPreferenceUtil {
    private final String PREF_NAME = "sishin";

    private final String PREF_KEY_COLUMN_COUNT = "pref_key_column_count";   //그리드뷰 가로아이템 수

    private Context mContext;
    private volatile static SharedPreferenceUtil mInstance = null;

    public static SharedPreferenceUtil getInstance(Context context) {
        if(mInstance == null){
            synchronized (SharedPreferenceUtil.class){
                if(mInstance == null){
                    mInstance = new SharedPreferenceUtil(context);
                }
            }
        }
        return mInstance;
    }

    public static SharedPreferenceUtil getInstance() {
        if(mInstance == null){
            synchronized (SharedPreferenceUtil.class){
                if(mInstance == null){
                    mInstance = new SharedPreferenceUtil(DelAppApplication.getAppContext());
                }
            }
        }
        return mInstance;
    }

    private SharedPreferenceUtil(Context context) {
        mContext = context;
    }


    // 값 저장하기 String

    public void put(String key, String value) {
        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.commit();
    }


    // 값 저장하기 boolean

    public void put(String key, boolean value) {
        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, value);
        editor.commit();

    }


    // 값 저장하기 int

    public void put(String key, int value) {

        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.commit();

    }


    //값 가져오기 String

    public String getValue(String key, String dftValue) {
        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
        try {
            return pref.getString(key, dftValue);
        } catch (Exception e) {
            return dftValue;
        }
    }


    //값 가져오기 int

    public int getValue(String key, int dftValue) {
        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
        try {
            return pref.getInt(key, dftValue);
        } catch (Exception e) {
            return dftValue;
        }
    }


    //값 가져오기 boolean

    public boolean getValue(String key, boolean dftValue) {
        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
        try {
            return pref.getBoolean(key, dftValue);
        } catch (Exception e) {
            return dftValue;
        }
    }


    // 값(Key Data) 삭제하기

    public void removePreferences(String key) {
        SharedPreferences pref = mContext.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(key);
        editor.commit();
    }

}

