package com.chyrus.rijksmuseum.ui.rijks;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.chyrus.rijksmuseum.R;
import com.chyrus.rijksmuseum.BR;
import com.chyrus.rijksmuseum.base.BaseFragment;
import com.chyrus.rijksmuseum.data.RijksModel;
import com.chyrus.rijksmuseum.databinding.FragmentRijksBinding;
import com.github.nitrico.lastadapter.LastAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RijksFragment extends BaseFragment<FragmentRijksBinding, RijksPresenter> implements RijksView {


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
        view.recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter.showRijks();
    }

    public void onRijksClicked(View view) {
        RijksModel data = (RijksModel) view.getTag();
        Toast.makeText(getActivity(), "item:" + data.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_rijks;
    }

    @Override
    public void onSuccess(List<RijksModel> res) {
        new LastAdapter(res, BR.item)
                .map(RijksModel.class, R.layout.item_rijks)
                .into(view.recyclerView1);
    }
}
