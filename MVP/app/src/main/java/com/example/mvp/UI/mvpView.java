package com.example.mvp.UI;

import com.example.mvp.beans.NewsData;

import java.util.List;

public interface mvpView {

    public void getData(List<NewsData.DatalistBean> newslistBeanList);
}
