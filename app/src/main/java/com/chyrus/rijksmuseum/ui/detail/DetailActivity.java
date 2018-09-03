package com.chyrus.rijksmuseum.ui.detail;

import android.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chyrus.rijksmuseum.R;
import com.chyrus.rijksmuseum.base.BaseActivity;
import com.chyrus.rijksmuseum.data.RijksModel;
import com.chyrus.rijksmuseum.databinding.ActivityDetailBinding;

import java.util.Objects;

public class DetailActivity extends BaseActivity<ActivityDetailBinding, DetailPresenter> implements DetailView {

    @Override
    protected ActivityDetailBinding contentView() {
        return DataBindingUtil.setContentView(this, R.layout.activity_detail);
    }

    @Override
    protected DetailPresenter initPresenter() {
        return new DetailPresenter(this);
    }

    @Override
    protected void onCreated() {
        initToolbar(getString(R.string.app_name), true, view.toolbar);
        RijksModel data = (RijksModel) getIntent().getExtras().getSerializable("data");
        if (data != null) {
            view.titleDetail.setText(Objects.requireNonNull(data).getTitle());
        }
        Glide.with(this).load(R.drawable.photo).into(view.imgDetail);
    }
}
