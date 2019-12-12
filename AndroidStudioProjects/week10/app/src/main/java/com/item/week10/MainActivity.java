package com.item.week10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.item.week10.Iconfont.IconfontTextview;
import com.item.week10.fragment.HomeFragment;
import com.item.week10.fragment.MeFragment;
import com.item.week10.fragment.ShopFragment;
import com.item.week10.fragment.SortFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView  icon_text_home;
    private TextView icon_text_sort;
    private TextView icon_text_shop;
    private TextView icon_text_me;
    private IconfontTextview icon_font_home;
    private IconfontTextview icon_font_sort;
    private IconfontTextview icon_font_shop;
    private IconfontTextview icon_font_me;

    private View include;

    private HomeFragment homeFragment;
    private SortFragment sortFragment;
    private ShopFragment shopFragment;
    private MeFragment meFragment;

    private FrameLayout fragment_container;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
    }

    private void bindView(){
        include=findViewById(R.id.tabitem);
        fragment_container=findViewById(R.id.fragment_container);
        icon_text_home=include.findViewById(R.id.icon_text_home);
        icon_text_sort=include.findViewById(R.id.icon_text_sort);
        icon_text_shop=include.findViewById(R.id.icon_text_shop);
        icon_text_me=include.findViewById(R.id.icon_text_me);
        icon_font_home=include.findViewById(R.id.icon_font_home);
        icon_font_sort=include.findViewById(R.id.icon_font_sort);
        icon_font_shop=include.findViewById(R.id.icon_font_shop);
        icon_font_me=include.findViewById(R.id.icon_font_me);
        icon_text_home.setOnClickListener(this);
        icon_text_sort.setOnClickListener(this);
        icon_text_shop.setOnClickListener(this);
        icon_text_me.setOnClickListener(this);
        icon_font_home.setOnClickListener(this);
        icon_font_sort.setOnClickListener(this);
        icon_font_shop.setOnClickListener(this);
        icon_font_me.setOnClickListener(this);
    }

    public void selected(){
        icon_text_home.setSelected(false);
        icon_text_sort.setSelected(false);
        icon_text_shop.setSelected(false);
        icon_text_me.setSelected(false);
        icon_font_home.setSelected(false);
        icon_font_sort.setSelected(false);
        icon_font_shop.setSelected(false);
        icon_font_me.setSelected(false);
    }

    //隐藏所有Fragment
    public void hideAllFragment(FragmentTransaction transaction){
        if(homeFragment!=null){
            transaction.hide(homeFragment);
        }
        if(sortFragment!=null){
            transaction.hide(sortFragment);
        }
        if(shopFragment!=null){
            transaction.hide(shopFragment);
        }
        if(meFragment!=null){
            transaction.hide(meFragment);
        }
    }


    @Override
    public void onClick(View v) {
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch (v.getId()){
            case R.id.icon_font_home:
                selected();
                icon_font_home.setSelected(true);
                icon_text_home.setSelected(true);
                if (homeFragment==null){
                    homeFragment=new HomeFragment();
                    transaction.add(R.id.fragment_container,homeFragment);
                }else {
                    transaction.show(homeFragment);
                }
                break;
            case R.id.icon_font_sort :
                selected();
                icon_font_sort.setSelected(true);
                icon_text_sort.setSelected(true);
                if (sortFragment==null){
                    sortFragment=new SortFragment();
                    transaction.add(R.id.fragment_container,sortFragment);
                }else {
                    transaction.show(sortFragment);
                }
                break;
            case R.id.icon_font_shop :
                selected();
                icon_font_shop.setSelected(true);
                icon_text_shop.setSelected(true);
                if (shopFragment==null){
                    shopFragment=new ShopFragment();
                    transaction.add(R.id.fragment_container,shopFragment);
                }else {
                    transaction.show(shopFragment);
                }
                break;
            case R.id.icon_font_me :
                selected();
                icon_font_me.setSelected(true);
                icon_text_me.setSelected(true);
                if (meFragment==null){
                    meFragment=new MeFragment();
                    transaction.add(R.id.fragment_container,meFragment);
                }else {
                    transaction.show(meFragment);
                }
                break;
                default:
                    break;

        }
        transaction.commit();


    }
}
