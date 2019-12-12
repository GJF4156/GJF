package com.item.testproject2.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.item.testproject2.R;
import com.item.testproject2.Utils.ImageUtils;
import com.item.testproject2.activity.SearchActivity;
import com.item.testproject2.fragment.sortDatas.presenter.ISortFragmentP;
import com.item.testproject2.fragment.sortDatas.presenter.SortFragmentPImpl;
import com.item.testproject2.fragment.sortDatas.view.ISortFragmentV;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SortFragment extends Fragment implements View.OnClickListener, ISortFragmentV {

    private TextView searchTextView;
    private ImageView kehuishoulaji,chuyulaji,youhailaji,qitalaji;

    private ISortFragmentP mPresenter;
    public SortFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sort, container, false);
        searchTextView=view.findViewById(R.id.searchTextView);
        kehuishoulaji=view.findViewById(R.id.kehuishoulaji);
        chuyulaji=view.findViewById(R.id.chuyulaji);
        youhailaji=view.findViewById(R.id.youhailaji);
        qitalaji=view.findViewById(R.id.qitalaji);
        mPresenter=new SortFragmentPImpl(this);
        kehuishoulaji.setOnClickListener(this);
        chuyulaji.setOnClickListener(this);
        youhailaji.setOnClickListener(this);
        qitalaji.setOnClickListener(this);
        searchTextView.setOnClickListener(this);
        mPresenter.getDatas();
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.searchTextView:
            startActivity(new Intent(getActivity(), SearchActivity.class));
            break;
            case R.id.kehuishoulaji:
                Toast.makeText(getActivity(),"可回收垃圾",Toast.LENGTH_SHORT).show();
                break;
            case R.id.chuyulaji:
                Toast.makeText(getActivity(),"厨余垃圾",Toast.LENGTH_SHORT).show();
                break;
            case R.id.youhailaji:
                Toast.makeText(getActivity(),"有害垃圾",Toast.LENGTH_SHORT).show();
                break;
            case R.id.qitalaji:
                Toast.makeText(getActivity(),"其他垃圾",Toast.LENGTH_SHORT).show();
                break;
                default:break;
        }
    }

    //List为对象类型
    @Override
    public void getDatas(List<String> contentlist) {
        /**
         * 此方法内给UI赋值
         */
    }
}
