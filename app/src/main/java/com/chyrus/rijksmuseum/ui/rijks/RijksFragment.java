package com.chyrus.rijksmuseum.ui.rijks;

import android.support.v4.app.Fragment;

import com.chyrus.rijksmuseum.R;
import com.chyrus.rijksmuseum.BR;
import com.chyrus.rijksmuseum.base.BaseFragment;
import com.chyrus.rijksmuseum.databinding.FragmentRijksBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class RijksFragment extends BaseFragment<FragmentRijksBinding,RijksPresenter> implements RijksView {


    public RijksFragment() {
        // Required empty public constructor
    }

    @Override
    protected RijksPresenter initPresenter() {
        return new RijksPresenter(this);
    }

    @Override
    protected void onCreated() {
        view.btLogout.setOnClickListener(view1 -> logOut());
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_rijks;
    }
}
