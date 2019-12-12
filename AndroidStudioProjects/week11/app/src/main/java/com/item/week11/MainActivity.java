package com.item.week11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;
    private TextView mTextView4;

    private Fragment indexFragment;
    private Fragment sortFragment;
    private Fragment shopFragment;
    private Fragment meFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setFragment(0);

    }

    public void init(){
        mTextView1=findViewById(R.id.shouye);
        mTextView2=findViewById(R.id.shop);
        mTextView3=findViewById(R.id.fenlei);
        mTextView4=findViewById(R.id.me);

        mTextView1.setOnClickListener(this);
        mTextView2.setOnClickListener(this);
        mTextView3.setOnClickListener(this);
        mTextView4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shouye:
                setFragment(0);
                break;
            case R.id.shop:
                setFragment(1);
                break;
            case R.id.fenlei:
                setFragment(2);
                break;
            case R.id.me:
                setFragment(3);
                break;
        }
    }

    private void setFragment(int index){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        hideFragments(ft);
        switch (index){
            case 0:
                //设置菜单栏为选中状态（修改文字和图片颜色）
                mTextView1.setTextColor(getResources().getColor(R.color.selectText));
                //显示对应Fragment
                if(indexFragment == null){
                    indexFragment = new IndexFragment();
                    ft.add(R.id.container, indexFragment,
                            "clothes_fragment");
                }else {
                    ft.show(indexFragment);
                }
                break;
            case 1:
                //设置菜单栏为选中状态（修改文字和图片颜色）
                mTextView2.setTextColor(getResources().getColor(R.color.selectText));
                //显示对应Fragment
                if(shopFragment == null){
                    shopFragment = new ShopFragment();
                    ft.add(R.id.container, shopFragment,
                            "shopFragment");
                }else {
                    ft.show(shopFragment);
                }
                break;
            case 2:
                //设置菜单栏为选中状态（修改文字和图片颜色）
                mTextView3.setTextColor(getResources().getColor(R.color.selectText));
                //显示对应Fragment
                if(sortFragment == null){
                    sortFragment = new SortFragment();
                    ft.add(R.id.container, sortFragment,
                            "sortFragment");
                }else {
                    ft.show(sortFragment);
                }
                break;
            case 3:
                //设置菜单栏为选中状态（修改文字和图片颜色）
                mTextView4.setTextColor(getResources().getColor(R.color.selectText));
                //显示对应Fragment
                if(meFragment == null){
                    meFragment = new MeFragment();
                    ft.add(R.id.container, meFragment,
                            "meFragment");
                }else {
                    ft.show(meFragment);
                }
                break;
                default:break;
        }
        ft.commit();

    }
    private void hideFragments(FragmentTransaction transaction){
        if(indexFragment != null){
            //隐藏Fragment
            transaction.hide(indexFragment);
            //将对应菜单栏设置为默认状态
            mTextView1.setTextColor(getResources()
                    .getColor(R.color.noselect));
        }
        if(sortFragment != null){
            transaction.hide(sortFragment);
            mTextView2.setTextColor(getResources()
                    .getColor(R.color.noselect));
        }
        if(shopFragment != null){
            transaction.hide(shopFragment);
            mTextView3.setTextColor(getResources()
                    .getColor(R.color.noselect));
        }
        if(meFragment != null){
            transaction.hide(meFragment);
            mTextView4.setTextColor(getResources()
                    .getColor(R.color.noselect));
        }
    }
}
