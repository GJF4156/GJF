package com.item.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.item.example.IconFont.FontIconView;
import com.item.example.adapter.TabBarAdapter;
import com.item.example.beans.IconText;
import com.item.example.fragment.HomeFragment;
import com.item.example.fragment.MeFragment;
import com.item.example.fragment.ShopFragment;
import com.item.example.fragment.SortFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private Fragment homeFragment;
    private Fragment sortFragment;
    private Fragment shopFragment;
    private Fragment meFragment;

    FontIconView fontIconView;
    TextView iconText;

    private List<IconText> iconList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setFragment(0);
        RecyclerView recyclerView = findViewById(R.id.tab_bar_recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        TabBarAdapter adapter = new TabBarAdapter(iconList, new TabBarAdapter.addClickListerner() {
            @Override
            public void addClick(int position) {
                switch (position) {
                    case 0:
                        setFragment(0);
                        Toast.makeText(HomeActivity.this,"点击了"+position,Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        setFragment(1);
                        break;
                    case 2:
                        setFragment(2);
                        break;
                    case 3:
                        setFragment(3);
                        break;
                }
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void init() {
        IconText homIcon = new IconText(R.string.home_icon, "首页");
        IconText sortIcon = new IconText(R.string.sort_icon, "分类");
        IconText shopIcon = new IconText(R.string.shop_icon, "商城");
        IconText meIcon = new IconText(R.string.me_icon, "我的");
        fontIconView = findViewById(R.id.tab_bar_icon);
        iconText = findViewById(R.id.tab_bar_icon_text);
        iconList.add(homIcon);
        iconList.add(sortIcon);
        iconList.add(shopIcon);
        iconList.add(meIcon);
    }


    /**
     * @param index 根据index的值，设置需要显示的Fragment
     */
    private void setFragment(int index) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        hideFragments(ft);
        switch (index) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    ft.add(R.id.fragment, homeFragment, "homeFragment");
                } else {
                    ft.show(homeFragment);
                }
                break;
            case 1:
                if (sortFragment == null) {
                    sortFragment = new SortFragment();
                    ft.add(R.id.fragment, sortFragment, "sortFragment");
                } else {
                    ft.show(sortFragment);
                }
                break;
            case 2:
                if (shopFragment == null) {
                    shopFragment = new ShopFragment();
                    ft.add(R.id.fragment, shopFragment, "shopFragment");
                } else {
                    ft.show(shopFragment);

                }
                break;
            case 3:
                if (meFragment == null) {
                    meFragment = new MeFragment();
                    ft.add(R.id.fragment, meFragment, "meFragment");
                } else {
                    ft.show(meFragment);
                }
                break;
            default:
                break;
        }
    }

    /**
     * @param transaction 隐藏所有的Fragment
     */
    @SuppressLint("ResourceAsColor")
    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            //隐藏Fragment
            transaction.hide(homeFragment);
        }
        if (sortFragment != null) {
            transaction.hide(sortFragment);
        }
        if (shopFragment != null) {
            transaction.hide(shopFragment);
        }
        if (meFragment != null) {
            transaction.hide(meFragment);
        }


    }
}
