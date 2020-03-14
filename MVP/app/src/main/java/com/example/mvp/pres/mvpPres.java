package com.example.mvp.pres;

import com.example.mvp.beans.NewsData;

import java.util.List;

public interface mvpPres {

    public void getData();

    public void returnData(List<NewsData.DatalistBean> newslistBeanList);
}
