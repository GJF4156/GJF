package com.item.testfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.item.testfragment.Adapter.MyFagmentPagerAdapter;
import com.item.testfragment.fragment.index_fragment;
import com.item.testfragment.fragment.me_fragment;
import com.item.testfragment.fragment.shop_fragment;
import com.item.testfragment.fragment.sort_fragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {


    private RadioGroup radioGroup;
    private RadioButton rg_index;
    private RadioButton rg_sort;
    private RadioButton rg_shop;
    private RadioButton rg_me;
    private ViewPager tab_bar;
    private MyFagmentPagerAdapter mAdapter;

    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        rg_index.setChecked(true);
    }
    public void bindView(){
        radioGroup=findViewById(R.id.rg_tab_bar);
        rg_index=findViewById(R.id.rg_index);
        rg_sort=findViewById(R.id.rg_sort);
        rg_shop=findViewById(R.id.rg_shop);
        rg_me=findViewById(R.id.rg_me);
        radioGroup.setOnCheckedChangeListener(this);
        tab_bar=findViewById(R.id.tab_bar);
        tab_bar.setAdapter(mAdapter);
        tab_bar.setCurrentItem(0);
        tab_bar.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rg_index:
                tab_bar.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rg_sort:
                tab_bar.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rg_shop:
                tab_bar.setCurrentItem(PAGE_THREE);
                break;
            case R.id.rg_me:
                tab_bar.setCurrentItem(PAGE_FOUR);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state==2){
            switch (tab_bar.getCurrentItem()){
                case PAGE_ONE:
                    rg_index.setChecked(true);
                    break;
                case PAGE_TWO:
                    rg_sort.setChecked(true);
                    break;
                case PAGE_THREE:
                    rg_shop.setChecked(true);
                    break;
                case PAGE_FOUR:
                    rg_me.setChecked(true);
                    break;
            }
        }
    }
}
