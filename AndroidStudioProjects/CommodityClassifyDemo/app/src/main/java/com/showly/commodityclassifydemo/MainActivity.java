package com.showly.commodityclassifydemo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.showly.commodityclassifydemo.adapter.ThemeMainAdapter;
import com.showly.commodityclassifydemo.bean.ThemeMainReq;
import com.showly.commodityclassifydemo.utils.SpaceItemDecoration;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ThemeMainAdapter.OnSelectorListener {

    private RecyclerView recyclerView;
    private ThemeMainAdapter adapter;
    private List<ThemeMainReq.DatasBean> datasBeanList;
    private ThemeFragment themeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initListener();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerview);

        //初始化recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new SpaceItemDecoration(getApplicationContext(), 5, 3));

        //初始化adapter
        adapter = new ThemeMainAdapter(this);
        adapter.setOnSelectorListener(this);
    }

    private void initData() {
        //模拟数据
        String response = "{\"datas\": [{\"id\": \"56\",\"showName\": \"清新\"},{\"id\": \"57\",\"showName\": \"复古\"},{\"id\": \"58\", \"showName\": \"古风\"},{\"id\": \"59\", \"showName\": \"盐系\"},{ \"id\": \"141\", \"showName\": \"暗黑\"},{  \"id\": \"62\", \"showName\": \"花草\"},{\"id\": \"63\", \"showName\": \"\n" +
                "美食物品\"},{ \"id\": \"64\", \"showName\": \"人物\" },{ \"id\": \"65\",  \"showName\": \"文字字母\"},{\"id\": \"67\", \"showName\": \"基础款\"},{\"id\": \"68\",\"showName\": \"风景\"},{ \"id\": \"70\", \"showName\": \"动物\"}]}\n";
        //对数据进行解析
        ThemeMainReq themeMainReq = new Gson().fromJson(response, ThemeMainReq.class);
        //获取分类集合
        datasBeanList = themeMainReq.getDatas();
        //数据处理
        dealWithData(datasBeanList);
    }

    private void dealWithData(List<ThemeMainReq.DatasBean> datasBeanList) {
        //传递数据
        adapter.setData(datasBeanList);
        recyclerView.setAdapter(adapter);
        //默认选中
        datasBeanList.get(0).setChick(true);
        //创建Fragment对象
        themeFragment = new ThemeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, themeFragment);

        //传递数据到Fragment
        Bundle mBundle = new Bundle();
        mBundle.putSerializable("info", datasBeanList.get(0));
        themeFragment.setArguments(mBundle);
        fragmentTransaction.commit();
    }

    private void initListener() {

    }

    @Override
    public void onSelect(View view, int position) {

        //选中处理
        ThemeMainReq.DatasBean datasBean = datasBeanList.get(position);
        for (int i = 0; i < datasBeanList.size(); i++) {
            if (datasBeanList.get(i).getShowName().equals(datasBean.getShowName())) {
                datasBeanList.get(i).setChick(true);
            } else {
                datasBeanList.get(i).setChick(false);
            }
        }

        //刷新列表
        adapter.notifyDataSetChanged();

        //创建Fragment对象
        themeFragment = new ThemeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, themeFragment);

        //传递数据到Fragment
        Bundle mBundle = new Bundle();
        mBundle.putSerializable("info", datasBeanList.get(position));
        themeFragment.setArguments(mBundle);
        fragmentTransaction.commit();
    }
}
