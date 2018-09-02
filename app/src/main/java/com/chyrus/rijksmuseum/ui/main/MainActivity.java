package com.chyrus.rijksmuseum.ui.main;

import android.databinding.DataBindingUtil;
import com.chyrus.rijksmuseum.R;
import com.chyrus.rijksmuseum.BR;
import com.chyrus.rijksmuseum.base.BaseActivity;
import com.chyrus.rijksmuseum.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainPresenter> implements MainView {

    @Override protected MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override protected ActivityMainBinding contentView() {
        return DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override protected void onCreated() {
    }

}
