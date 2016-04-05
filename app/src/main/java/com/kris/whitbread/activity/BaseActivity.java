package com.kris.whitbread.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;


import com.kris.whitbread.R;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    private SharedPreferences mSharedPrefs;
    private View mToolbarLayout;
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupView();
        mSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
    }

    protected void setHomeButtonBackEnabled() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    protected SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        LayoutInflater.from(this).inflate(layoutResID, mLinearLayout, true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                this.onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void closeKeyboard() {
        InputMethodManager imm = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }

    private void setupView() {

        mLinearLayout = new LinearLayout(this);
        mLinearLayout.setOrientation(LinearLayout.VERTICAL);

        super.setContentView(mLinearLayout, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        mToolbarLayout = getLayoutInflater().inflate(R.layout.toolbar, mLinearLayout, false);

        mLinearLayout.addView(mToolbarLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        final Toolbar toolbar = ButterKnife.findById(mToolbarLayout, R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);
    }

    public int getStatusBarHeight() {
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return getResources().getDimensionPixelSize(resourceId);
        }
        return 0;
    }

    protected int getIntentExtraInt(String key, int defaultValue) {
        final Bundle args = getIntent().getExtras();
        if (args != null) {
            return args.getInt(key);
        }
        return defaultValue;
    }

    protected <T extends Parcelable> T getIntentExtraParcelable(String key, T defaultValue) {
        final Bundle args = getIntent().getExtras();
        if (args != null) {
            return args.getParcelable(key);
        }
        return defaultValue;
    }

    protected void inflateFragment(int containerViewId, Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction()
                .replace(containerViewId, fragment, tag)
                .commit();
    }

    protected void finishWithoutAnimation() {
        finish();
        overridePendingTransition(0, 0);
    }

}
