package com.showly.commodityclassifydemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.showly.commodityclassifydemo.bean.ThemeMainReq;

public class ThemeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.myfragment, null);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        //得到数据
        ThemeMainReq.DatasBean info = (ThemeMainReq.DatasBean) getArguments().getSerializable("info");
        tv_title.setText(info.getShowName());
        return view;
    }

}
