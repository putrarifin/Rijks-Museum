package com.chyrus.rijksmuseum.ui.register;

import android.widget.CheckBox;

import com.chyrus.rijksmuseum.base.BasePresenter;
import com.chyrus.rijksmuseum.data.UserModel;
import com.chyrus.rijksmuseum.utils.PrefManager;

public class RegisterPresenter extends BasePresenter<RegisterView> {

    public RegisterPresenter(RegisterView view) {
        attachView(view);
    }

    void register(String username, String password, CheckBox checkBox) {
        if (username.trim().isEmpty()) {
            view().onError("Username should not be empty");
            return;
        }
        if (password.trim().isEmpty()) {
            view().onError("Password should not be empty");
            return;
        }

        if (!checkBox.isChecked()) {
            view().onError("Checkbox should not be checked");
            return;
        }

        realm().executeTransaction(realm -> {
            UserModel user = realm.where(UserModel.class).equalTo("username", username).findFirst();
            if (user != null)
                view().onError("User is registered!");
            else {
                UserModel newUser = new UserModel(username,password);
                realm.insertOrUpdate(newUser);
                PrefManager.initPreferences().setLogin(true);
                PrefManager.initPreferences().setUser(new UserModel(username,password));
                view().goMain();
            }
        });
    }
}
