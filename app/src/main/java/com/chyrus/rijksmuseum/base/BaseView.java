package com.chyrus.rijksmuseum.base;

import android.support.annotation.StringRes;

public interface BaseView {

    void showLoading();

    void hideLoading();

    void onError(String message);

    void onError(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();

    void logOut();

}
