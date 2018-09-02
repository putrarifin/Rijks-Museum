package com.chyrus.rijksmuseum.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chyrus.rijksmuseum.ui.login.LoginActivity;
import com.chyrus.rijksmuseum.utils.ActivityUtils;
import com.chyrus.rijksmuseum.utils.KeyboardUtils;
import com.chyrus.rijksmuseum.utils.NetworkUtils;
import com.chyrus.rijksmuseum.utils.PrefManager;
import com.chyrus.rijksmuseum.utils.ProgressLoader;

abstract public class BaseFragment<T extends ViewDataBinding, P extends BasePresenter> extends Fragment implements BaseView {

    protected T view;
    protected P presenter;

    protected abstract P initPresenter();

    protected abstract void onCreated();

    private View mRootView;

    private ProgressLoader loader;

    private BaseActivity mActivity;

    public abstract
    @LayoutRes
    int getLayoutId();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mRootView = view.getRoot();
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loader = new ProgressLoader(getActivity());
        presenter = initPresenter();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(false);
    }

    @Override
    public void onStart() {
        super.onStart();
        onCreated();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            this.mActivity = (BaseActivity) context;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mActivity = null;
        presenter.dettachView();
    }

    @Override
    public void showLoading() {
        loader.show();
    }

    @Override
    public void hideLoading() {
        loader.hide();
    }

    @Override
    public void onError(String message) {
        Snackbar snackbar = Snackbar.make(mActivity.findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        android.view.View sbView = snackbar.getView();
        TextView textView = sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(mActivity, android.R.color.white));
        snackbar.show();
    }

    @Override
    public void onError(@StringRes int resId) {
        onError(getString(resId));
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(mActivity);
    }

    @Override
    public void hideKeyboard() {
        KeyboardUtils.hideSoftInput(mActivity);
    }

    @Override
    public void logOut() {
        PrefManager.initPreferences().setLogin(false);
        ActivityUtils.start(getActivity(), LoginActivity.class);
    }

    protected BaseActivity getBaseActivity() {
        return mActivity;
    }

    @Override
    public void initToolbar(String title, boolean backhome, Toolbar toolbar) {

    }
}
