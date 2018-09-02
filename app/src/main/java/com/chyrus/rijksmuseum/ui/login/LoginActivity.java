package com.chyrus.rijksmuseum.ui.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;

import com.chyrus.rijksmuseum.R;
import com.chyrus.rijksmuseum.base.BaseActivity;
import com.chyrus.rijksmuseum.databinding.ActivityLoginBinding;
import com.chyrus.rijksmuseum.ui.main.MainActivity;
import com.chyrus.rijksmuseum.ui.register.RegisterActivity;
import com.chyrus.rijksmuseum.utils.ActivityUtils;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginPresenter> implements LoginView {

    @Override
    protected ActivityLoginBinding contentView() {
        return DataBindingUtil.setContentView(this, R.layout.activity_login);
    }

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected void onCreated() {
        view.tvRegister.setOnClickListener(view1 -> startActivity(new Intent(this, RegisterActivity.class)));
        view.btLogin.setOnClickListener(view1 -> presenter.login(view.etUsername.getText().toString(), view.etPassword.getText().toString()));
    }

    @Override
    public void goMain() {
        ActivityUtils.start(this, MainActivity.class);
    }
}
