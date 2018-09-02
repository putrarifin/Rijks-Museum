package com.chyrus.rijksmuseum.ui.profile;

import com.chyrus.rijksmuseum.base.BasePresenter;
import com.chyrus.rijksmuseum.utils.PrefManager;

public class ProfilePresenter extends BasePresenter<ProfileView> {

    public ProfilePresenter(ProfileView view) {
        attachView(view);
    }

    void getUser() {
        view().setProfile(PrefManager.initPreferences().getUser());
    }
}
