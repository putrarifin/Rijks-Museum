package com.chyrus.rijksmuseum.base;

import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;

public interface BaseView {

    void showLoading();

    void hideLoading();

    void onError(String message);

    void onError(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();

    void logOut();

    void initToolbar(String title, boolean backhome, Toolbar toolbar);

}
