package com.kris.whitbread;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class App extends Application {

    private static Context mContext;
    private static SharedPreferences mSharedPref;
    private static DataManager mDataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        mSharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        mContext = this;
    }

    public static SharedPreferences getSharedPref() {
        return mSharedPref;
    }

    public static DataManager getDataManager() {
        if (mDataManager == null){
            mDataManager = new DataManager(mSharedPref, mContext);
        }

        return mDataManager;
    }
}
