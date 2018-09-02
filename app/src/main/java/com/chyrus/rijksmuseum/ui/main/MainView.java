package com.chyrus.rijksmuseum.ui.main;

import android.support.v4.app.Fragment;

import com.chyrus.rijksmuseum.base.BaseView;

interface MainView extends BaseView {

    void loadFragment(Fragment fragment);

}
