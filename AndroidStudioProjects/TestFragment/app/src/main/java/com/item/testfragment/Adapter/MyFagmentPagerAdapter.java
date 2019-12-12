package com.item.testfragment.Adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.item.testfragment.MainActivity;
import com.item.testfragment.fragment.index_fragment;
import com.item.testfragment.fragment.me_fragment;
import com.item.testfragment.fragment.shop_fragment;
import com.item.testfragment.fragment.sort_fragment;

public class MyFagmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGER_COUNT=4;
    private index_fragment indexFragment=null;
    private sort_fragment sortFragment=null;
    private shop_fragment shopFragment=null;
    private me_fragment meFragment=null;

    public MyFagmentPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        indexFragment = new index_fragment();
        sortFragment = new sort_fragment();
        shopFragment=new shop_fragment();
        meFragment=new me_fragment();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case MainActivity
                    .PAGE_ONE:
                fragment=indexFragment;
            break;
            case MainActivity.PAGE_TWO:
                fragment=sortFragment;
                break;
            case MainActivity.PAGE_THREE:
                 fragment=shopFragment;
                 break;
                 case MainActivity.PAGE_FOUR:
                     fragment=meFragment;
                     break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }
}
