package com.chyrus.rijksmuseum.ui.register;

import android.databinding.DataBindingUtil;
import android.widget.Toast;

import com.chyrus.rijksmuseum.R;
import com.chyrus.rijksmuseum.base.BaseActivity;
import com.chyrus.rijksmuseum.databinding.ActivityRegisterBinding;
import com.chyrus.rijksmuseum.ui.main.MainActivity;
import com.chyrus.rijksmuseum.utils.ActivityUtils;

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding, RegisterPresenter> implements RegisterView {


    @Override
    protected ActivityRegisterBinding contentView() {
        return DataBindingUtil.setContentView(this, R.layout.activity_register);
    }

    @Override
    protected RegisterPresenter initPresenter() {
        return new RegisterPresenter(this);
    }

    @Override
    protected void onCreated() {
        initToolbar(getString(R.string.app_name), true, view.toolbar);
        view.btRegister.setOnClickListener(view1 -> presenter.register(view.etUsername.getText().toString(), view.etPassword.getText().toString(), view.checkAgree));
    }

    @Override
    public void goMain() {
        ActivityUtils.start(this, MainActivity.class);
    }
}
