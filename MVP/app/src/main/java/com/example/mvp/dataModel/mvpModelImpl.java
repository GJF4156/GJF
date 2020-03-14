package com.example.mvp.dataModel;

import android.util.Log;

import com.example.mvp.beans.NewsData;
import com.example.mvp.pres.mvpPres;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

public class mvpModelImpl implements mvpModel {
    private mvpPres mPresenter;

    public mvpModelImpl(mvpPres presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void getData() {

        String url="http://129.211.75.130:8080/demo/garbage/listGarbage?name=眼镜";
        RequestParams params = new RequestParams(url);

        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                NewsData newsData=new Gson().fromJson(result,NewsData.class);
                List<NewsData.DatalistBean> list=newsData.getDatalist();
                mPresenter.returnData(list);
                Log.d("TAG","model哈哈哈哈哈哈哈哈哈哈");
                Log.d("TAG","================================================================\n"+list.get(0).getGname());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.d("TAG","error哈哈哈哈哈哈哈哈哈哈");
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.d("TAG","Cancelled哈哈哈哈哈哈哈哈哈哈");
            }

            @Override
            public void onFinished() {
                Log.d("TAG","Finished哈哈哈哈哈哈哈哈哈哈");
            }
        });
    }
}
