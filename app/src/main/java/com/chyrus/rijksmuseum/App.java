package com.chyrus.rijksmuseum;

import android.app.Application;
import android.content.SharedPreferences;

public class App extends Application{

    private static App mInstance;

    public static synchronized App getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

    }

    public SharedPreferences getSharedPreferences() {
        return getSharedPreferences("MyApps", MODE_PRIVATE);
    }

}
