package com.example.mvp.pres;

import android.util.Log;

import com.example.mvp.UI.mvpView;
import com.example.mvp.beans.NewsData;
import com.example.mvp.dataModel.mvpModel;
import com.example.mvp.dataModel.mvpModelImpl;

import java.util.List;

public class mvpPresImpl implements mvpPres {
    private mvpView mView;

    private mvpModel mModel;

    public mvpPresImpl(mvpView view) {
        this.mView = view;
        mModel=new mvpModelImpl(this);
    }

    @Override
    public void getData() {
        mModel.getData();



    }

    @Override
    public void returnData(List<NewsData.DatalistBean> newslistBeanList) {
        mView.getData(newslistBeanList);
    }
}
