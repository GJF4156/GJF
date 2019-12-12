package com.item.testproject2.activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.item.testproject2.R;
import com.item.testproject2.fragment.HomeFragment;
import com.item.testproject2.fragment.MeFragment;
import com.item.testproject2.fragment.ShopFragment;
import com.item.testproject2.fragment.SortFragment;
public class BottomBarActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView home_tv_bar;
    private TextView shop_tv_bar;
    private TextView sort_tv_bar;
    private TextView me_tv_bar;
    private Fragment homeFragment;
    private Fragment sortFragment;
    private Fragment shopFragment;
    private Fragment meFragment;
    Drawable top;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar);
        init();
        setFragment(0);
    }
    /**
     * 初始化组件
     */
    public void init() {
        home_tv_bar = findViewById(R.id.home_tv_bar);
        sort_tv_bar = findViewById(R.id.sort_tv_bar);
        shop_tv_bar = findViewById(R.id.shop_tv_bar);
        me_tv_bar = findViewById(R.id.me_tv_bar);
        home_tv_bar.setOnClickListener(this);
        sort_tv_bar.setOnClickListener(this);
        shop_tv_bar.setOnClickListener(this);
        me_tv_bar.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.home_tv_bar:
                setFragment(0);
                break;
            case R.id.sort_tv_bar:
                setFragment(1);
                break;
            case R.id.shop_tv_bar:
                setFragment(2);
                break;
            case R.id.me_tv_bar:
                setFragment(3);
                break;
        }
    }
    /**
     * @param index 根据index设置需要显示的Fragment
     */
    private void setFragment(int index) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        hideFragments(ft);
        switch (index) {
            case 0:
                top = getResources().getDrawable(R.mipmap.home1);
                home_tv_bar.setTextColor(getResources().getColor(R.color.select_text_color));
                home_tv_bar.setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    ft.add(R.id.fragment, homeFragment);
                } else {
                    ft.show(homeFragment);
                }
                break;
            case 1:
                top = getResources().getDrawable(R.mipmap.sort1);
                sort_tv_bar.setTextColor(getResources().getColor(R.color.select_text_color));
                sort_tv_bar.setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);
                if (sortFragment == null) {
                    sortFragment = new SortFragment();
                    ft.add(R.id.fragment, sortFragment);
                } else {
                    ft.show(sortFragment);
                }
                break;
            case 2:
                top = getResources().getDrawable(R.mipmap.shop1);
                shop_tv_bar.setTextColor(getResources().getColor(R.color.select_text_color));
                shop_tv_bar.setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);
                if (shopFragment == null) {
                    shopFragment = new ShopFragment();
                    ft.add(R.id.fragment, shopFragment);
                } else {
                    ft.show(shopFragment);
                }
                break;
            case 3:
                top = getResources().getDrawable(R.mipmap.me1);
                me_tv_bar.setTextColor(getResources().getColor(R.color.select_text_color));
                me_tv_bar.setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);
                if (meFragment == null) {
                    meFragment = new MeFragment();
                    ft.add(R.id.fragment, meFragment);
                } else {
                    ft.show(meFragment);
                }
                break;
            default:
                break;
        }
        ft.commit();
    }
    /**
     * @param transaction 隐藏所有的Fragment
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            top = getResources().getDrawable(R.mipmap.home);
            transaction.hide(homeFragment);
            home_tv_bar.setTextColor(getResources().getColor(R.color.no_select_text_color));
            home_tv_bar.setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);
        }
        if (sortFragment != null) {
            top = getResources().getDrawable(R.mipmap.sort);
            transaction.hide(sortFragment);
            sort_tv_bar.setTextColor(getResources().getColor(R.color.no_select_text_color));
            sort_tv_bar.setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);
        }
        if (shopFragment != null) {
            top = getResources().getDrawable(R.mipmap.shop);
            transaction.hide(shopFragment);
            shop_tv_bar.setTextColor(getResources().getColor(R.color.no_select_text_color));
            shop_tv_bar.setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);
        }
        if (meFragment != null) {
            top = getResources().getDrawable(R.mipmap.me);
            transaction.hide(meFragment);
            me_tv_bar.setTextColor(getResources().getColor(R.color.no_select_text_color));
            me_tv_bar.setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);
        }
    }
}
