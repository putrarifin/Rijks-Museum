package com.chyrus.rijksmuseum.ui.main;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chyrus.rijksmuseum.R;
import com.chyrus.rijksmuseum.base.BaseActivity;
import com.chyrus.rijksmuseum.databinding.ActivityMainBinding;
import com.chyrus.rijksmuseum.ui.profile.ProfileFragment;
import com.chyrus.rijksmuseum.ui.rijks.RijksFragment;
import com.chyrus.rijksmuseum.utils.PrefManager;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainPresenter> implements MainView, NavigationView.OnNavigationItemSelectedListener {

    private long exitTime;

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected ActivityMainBinding contentView() {
        return DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    protected void onCreated() {
        initToolbar(getString(R.string.app_name), false, view.toolbar);
        loadFragment(new RijksFragment());
        setupNavDraw();
    }

    @Override
    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            loadFragment(new RijksFragment());
        } else if (id == R.id.nav_profile) {
            loadFragment(new ProfileFragment());
        }

        view.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setupNavDraw() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, view.drawerLayout, view.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        view.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        view.navView.setNavigationItemSelectedListener(this);
        ImageView imgNav = view.navView.getHeaderView(0).findViewById(R.id.item_nav_icon);
        TextView usernameNav = view.navView.getHeaderView(0).findViewById(R.id.item_nav_name);
        usernameNav.setText(PrefManager.initPreferences().getUser().getUsername());
        Glide.with(this).load(R.drawable.photo).apply(RequestOptions.circleCropTransform()).into(imgNav);
    }

    public void doExitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, R.string.press_again_exit_app, Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        if (view.drawerLayout.isDrawerOpen(GravityCompat.END)) {
            view.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            doExitApp();
        }
    }
}
