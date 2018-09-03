package com.chyrus.rijksmuseum.ui.rijks;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.chyrus.rijksmuseum.R;
import com.chyrus.rijksmuseum.BR;
import com.chyrus.rijksmuseum.base.BaseFragment;
import com.chyrus.rijksmuseum.data.RijksModel;
import com.chyrus.rijksmuseum.databinding.FragmentRijksBinding;
import com.chyrus.rijksmuseum.ui.detail.DetailActivity;
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
        view.rvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter.showRijks();
    }

    public void onPortClicked(View view) {
        RijksModel data = (RijksModel) view.getTag();
//        Toast.makeText(getActivity(), "item:" + data.getTitle(), Toast.LENGTH_SHORT).show();

        Intent detail = new Intent(getActivity(), DetailActivity.class);
        detail.putExtra("data", data);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_rijks;
    }

    @Override
    public void onSuccess(List<RijksModel> res) {
        new LastAdapter(res, BR.item)
                .map(RijksModel.class, R.layout.item_rijks)
                .into(view.rvList);
    }
}
