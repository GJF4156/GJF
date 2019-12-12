package com.item.testproject2.fragment.sortDatas.presenter;

import com.item.testproject2.fragment.sortDatas.model.ISortFragmentM;
import com.item.testproject2.fragment.sortDatas.model.SortFragmentMImpl;
import com.item.testproject2.fragment.sortDatas.view.ISortFragmentV;

import java.util.List;

public class SortFragmentPImpl implements ISortFragmentP {
    private ISortFragmentM mModel;
    private ISortFragmentV mView;

    public SortFragmentPImpl(ISortFragmentV iSortFragmentV) {
        mView = iSortFragmentV;
        mModel = new SortFragmentMImpl(this);
    }

    @Override
    public void getDatas() {
            mModel.getDatas();
    }

    @Override
    public void returnDatas(List<String> contentlist) {
        mView.getDatas(contentlist);
    }
}
