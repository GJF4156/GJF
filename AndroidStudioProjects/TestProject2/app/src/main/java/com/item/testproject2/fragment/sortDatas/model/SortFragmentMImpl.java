package com.item.testproject2.fragment.sortDatas.model;

import com.item.testproject2.fragment.sortDatas.presenter.ISortFragmentP;

public class SortFragmentMImpl implements ISortFragmentM {
    private ISortFragmentP mPresenter;

    public SortFragmentMImpl(ISortFragmentP iSortFragmentP) {
        mPresenter = iSortFragmentP;
    }

    @Override
    public void getDatas() {
        //数据请求

    }
}
