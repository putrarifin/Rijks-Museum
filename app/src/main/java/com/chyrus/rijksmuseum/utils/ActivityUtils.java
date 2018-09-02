package com.chyrus.rijksmuseum.utils;

import android.app.Activity;
import android.content.Intent;

public class ActivityUtils {

    public static void start(Activity currentActivity, Class<? extends Activity> newTopActivityClass) {
        Intent intent = new Intent(currentActivity, newTopActivityClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        currentActivity.startActivity(intent);
        currentActivity.finish();
    }


}
