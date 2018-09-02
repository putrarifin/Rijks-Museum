package com.chyrus.rijksmuseum.utils;

import android.content.SharedPreferences;

import com.chyrus.rijksmuseum.App;
import com.chyrus.rijksmuseum.data.UserModel;

public class PrefManager {

    private static SharedPreferences preferences;

    public static PrefManager initPreferences() {
        preferences = App.getInstance().getSharedPreferences();
        return new PrefManager();
    }

    public UserModel getUser() {
        return new UserModel(
                preferences.getString(ConstantApp.PREF_USERNAME, ""), ""
        );
    }

    public void setUser(UserModel data) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(ConstantApp.PREF_USERNAME, data.getUsername());
        editor.apply();
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
