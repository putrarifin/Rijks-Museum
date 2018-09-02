package com.chyrus.rijksmuseum.ui.detail;

import android.databinding.DataBindingUtil;

import com.chyrus.rijksmuseum.R;
import com.chyrus.rijksmuseum.base.BaseActivity;
import com.chyrus.rijksmuseum.databinding.ActivityDetailBinding;

public class DetailActivity extends BaseActivity<ActivityDetailBinding,DetailPresenter> implements DetailView {

    @Override
    protected ActivityDetailBinding contentView() {
        return DataBindingUtil.setContentView(this,R.layout.activity_detail);
    }

    @Override
    protected DetailPresenter initPresenter() {
        return new DetailPresenter(this);
    }

    @Override
    protected void onCreated() {
        initToolbar(getString(R.string.app_name),true,view.toolbar);

    }
}
