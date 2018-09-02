package com.chyrus.rijksmuseum.ui.login;

import com.chyrus.rijksmuseum.base.BasePresenter;
import com.chyrus.rijksmuseum.data.UserModel;
import com.chyrus.rijksmuseum.utils.PrefManager;

import io.realm.Realm;

public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(LoginView view) {
        attachView(view);
    }

    void login(String username, String password) {
        if (username.trim().isEmpty()) {
            view().onError("Username should not be empty");
            return;
        }
        if (password.trim().isEmpty()) {
            view().onError("Password should not be empty");
            return;
        }

        realm().executeTransaction(realm -> {
            UserModel user = realm.where(UserModel.class).equalTo("username", username).findFirst();
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    view().onError("Login Success!");
                    PrefManager.initPreferences().setLogin(true);
                    view().goMain();
                } else
                    view().onError("Authentication Failed!");
            } else {
                view().onError("User not found!");
            }
        });
    }

}