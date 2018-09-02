package com.chyrus.rijksmuseum.ui.profile;


import android.support.v4.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chyrus.rijksmuseum.R;
import com.chyrus.rijksmuseum.base.BaseFragment;
import com.chyrus.rijksmuseum.data.UserModel;
import com.chyrus.rijksmuseum.databinding.FragmentProfileBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends BaseFragment<FragmentProfileBinding, ProfilePresenter> implements ProfileView {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    protected ProfilePresenter initPresenter() {
        return new ProfilePresenter(this);
    }

    @Override
    protected void onCreated() {
        view.btLogout.setOnClickListener(view1 -> logOut());
        presenter.getUser();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_profile;
    }

    @Override
    public void setProfile(UserModel userModel) {
        view.tvUsername.setText(userModel.getUsername());
        Glide.with(getBaseActivity()).load(R.drawable.photo).apply(RequestOptions.circleCropTransform()).into(view.imgProfile);
    }
}
