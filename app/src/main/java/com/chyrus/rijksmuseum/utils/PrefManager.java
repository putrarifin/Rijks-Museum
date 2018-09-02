package com.chyrus.rijksmuseum.utils;

import android.content.SharedPreferences;

import com.chyrus.rijksmuseum.App;

public class PrefManager {

    private static SharedPreferences preferences;

    public static PrefManager initPreferences() {
        preferences = App.getInstance().getSharedPreferences();
        return new PrefManager();
    }

    public void clearPref() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }

    public void setLogin(boolean isLoggedIn) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(ConstantApp.KEY_IS_LOGGEDIN, isLoggedIn);
        editor.apply();
    }

    public boolean isLoggedIn() {
        return preferences.getBoolean(ConstantApp.KEY_IS_LOGGEDIN, false);
    }

}
