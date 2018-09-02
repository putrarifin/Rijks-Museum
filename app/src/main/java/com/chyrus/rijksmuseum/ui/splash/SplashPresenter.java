package com.chyrus.rijksmuseum.ui.splash;

import android.os.Handler;

import com.chyrus.rijksmuseum.base.BasePresenter;
import com.chyrus.rijksmuseum.utils.PrefManager;

public class SplashPresenter extends BasePresenter<SplashView> {

    SplashPresenter(SplashView view) {
        attachView(view);
    }

    public void waitSplash(int duration) {
        new Handler().postDelayed(() -> view().startActivity(PrefManager.initPreferences().isLoggedIn()), duration);
    }
}
