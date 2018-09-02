package com.chyrus.rijksmuseum.ui.splash;

import android.databinding.DataBindingUtil;

import com.chyrus.rijksmuseum.R;
import com.chyrus.rijksmuseum.base.BaseActivity;
import com.chyrus.rijksmuseum.databinding.ActivitySplashBinding;
import com.chyrus.rijksmuseum.ui.login.LoginActivity;
import com.chyrus.rijksmuseum.ui.login.LoginPresenter;
import com.chyrus.rijksmuseum.ui.main.MainActivity;
import com.chyrus.rijksmuseum.utils.ActivityUtils;
import com.chyrus.rijksmuseum.utils.ConstantApp;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashPresenter> implements SplashView {


    @Override
    protected ActivitySplashBinding contentView() {
        return DataBindingUtil.setContentView(this, R.layout.activity_splash);
    }

    @Override
    protected SplashPresenter initPresenter() {
        return new SplashPresenter(this);
    }

    @Override
    protected void onCreated() {
        presenter.waitSplash(ConstantApp.DURATION_SPLASH);
    }

    @Override
    public void startActivity(boolean islogin) {
        ActivityUtils.start(this, islogin ? MainActivity.class : LoginActivity.class);
    }
}
