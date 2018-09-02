package com.chyrus.rijksmuseum;

import android.app.Application;
import android.content.SharedPreferences;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application{

    private static App mInstance;

    public static synchronized App getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

        Realm.init(getApplicationContext());
        //Realm Db Config
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("my_app.realm")
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        // Use the config
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    public SharedPreferences getSharedPreferences() {
        return getSharedPreferences("MyApps", MODE_PRIVATE);
    }

}
