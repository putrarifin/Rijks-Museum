package com.chyrus.rijksmuseum.ui.profile;

import com.chyrus.rijksmuseum.base.BaseView;
import com.chyrus.rijksmuseum.data.UserModel;

public interface ProfileView extends BaseView{

    void setProfile(UserModel userModel);

}
