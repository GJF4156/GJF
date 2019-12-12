package com.diabin.fastec;

import android.os.Bundle;
import android.support.v7.app.ActionBar;

import com.flj.latte.activities.ProxyActivity;
import com.flj.latte.fragments.LatteFragment;
import com.flj.latte.global.Latte;

public class ExampleActivity extends ProxyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Latte.getConfigurator().withActivity(this);
    }

    @Override
    public LatteFragment setRootFragment() {
        return WebExampleFragment.create(Config.INDEX_URL);
    }
}
