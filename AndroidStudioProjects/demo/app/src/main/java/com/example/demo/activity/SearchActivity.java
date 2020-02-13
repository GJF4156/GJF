package com.example.demo.activity;

import android.annotation.SuppressLint;
import android.widget.SearchView;
import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.example.demo.Utils.DividerItemDecoration;
import com.example.demo.adapter.RvAdapter;
import com.example.demo.base.BaseActivity;
import com.example.demo.beans.SortsBean;
import com.example.demo.myView.CustomDialog;
import com.google.gson.Gson;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

@ContentView(R.layout.activity_search)//相当于setContentView(R.layout.activity_search);
public class SearchActivity extends BaseActivity {
    @ViewInject(R.id.recyclerview)//注解形式初始化组建，类似于findViewById();
    private RecyclerView recyclerView;
    @ViewInject(R.id.searchView)
    private SearchView searchView;
    private String url, url1;
    private List<SortsBean.NewslistBean> mStrs = null;//可通过获取网络数据进行实例化,保存请求来的数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        //初始化请求路劲url
        //url1 = "https://service.xiaoyuan.net.cn/garbage/index/search?kw=";//已经被限制请求次数
        //url1="https://laji.lr3800.com/api.php?name=";//免费无限制，不需要账号
        //url="https://www.lajiflw.cn/rubbish/category";//根据类别检索垃圾（不全），免费不要账号
        url1 = "http://api.tianapi.com/txapi/lajifenlei/index?key=a24ff874e046c94eb472e3a7692900e3&word=";//需要账号APIKEY，有次数限制，普通会员5000次
        //设置recyclerview的布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(SearchActivity.this));
        //设置recyclerview每项的分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        //设置searchview的监听事件
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {//点击 搜索 按钮后出发的事件
                url = url1 + query;
                loadData(url);//开始请求数据，传入url
                url = url1;
                return true;
            }

            //当输入框内容变化时调用的方法
            @Override
            public boolean onQueryTextChange(String newText) {//输入框内文本变化时触发的事件
//                url = url1 + newText;
//                loadData(url);
//                url=url1;
                return false;
            }
        });
    }

    //请求成功时回掉的函数
    @Override
    public void onSuccess(String result) {
        SortsBean sortsBean = new Gson().fromJson(result, SortsBean.class);
        if (sortsBean.getCode() == 200) {
            mStrs = sortsBean.getNewslist();
//        Log.d("TAG","===============\n\n\n"+mStrs);
            //设置recyclerview的适配器，并设置点击事件
            recyclerView.setAdapter(new RvAdapter(SearchActivity.this, mStrs, new RvAdapter.OnItemClickListener() {
                @SuppressLint("ResourceType")
                @Override
                public void onClick(int position) {
                    //显示dialog
                    toshowDialog(mStrs, position);
                }
            }));
        } else {
            Toast.makeText(SearchActivity.this, "没有搜索到或暂未收入......", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 显示dialog的方法
     *
     * @param mStrs    数据源列表
     * @param position 列表下标
     */
    public void toshowDialog(List<SortsBean.NewslistBean> mStrs, int position) {
        CustomDialog dialog = new CustomDialog(SearchActivity.this, R.style.custom_dialog);
        dialog.setName(mStrs.get(position).getName())
                .setDescription(mStrs.get(position).getExplain())
                .setChangjian("常见包括")
                .setChangjiancontent(mStrs.get(position).getContain())
                .setDelivery("投放要求")
                .setDeliverycontent(mStrs.get(position).getTip());
        /**
         * 根据类型的不同显示不同的结果
         */
        switch (mStrs.get(position).getType()) {
            case 0:
                //可回收垃圾
                dialog.setIcon(R.string.recyclableFont);
                dialog.setCardVieDgColor(getColor(R.color.recyclableFontColor));
                dialog.setIconColor(getColor(R.color.recyclableFontColor));
                dialog.setSortNameColor(getColor(R.color.recyclableFontColor));
                dialog.setChangJianColor(getColor(R.color.recyclableFontColor));
                dialog.setDeliveryColor(getColor(R.color.recyclableFontColor));
                dialog.setSortname("可回收垃圾");
                break;
            case 1:
                //有害垃圾
                dialog.setIcon(R.string.hazardousFont);
                dialog.setCardVieDgColor(getColor(R.color.hazardousFontColor));
                dialog.setIconColor(getColor(R.color.hazardousFontColor));
                dialog.setSortNameColor(getColor(R.color.hazardousFontColor));
                dialog.setChangJianColor(getColor(R.color.hazardousFontColor));
                dialog.setDeliveryColor(getColor(R.color.hazardousFontColor));
                dialog.setSortname("有害垃圾");
                break;
            case 2:
                //厨余垃圾
                dialog.setIcon(R.string.kitchenFont);
                dialog.setCardVieDgColor(getColor(R.color.kitchenFontColor));
                dialog.setIconColor(getColor(R.color.kitchenFontColor));
                dialog.setSortNameColor(getColor(R.color.kitchenFontColor));
                dialog.setChangJianColor(getColor(R.color.kitchenFontColor));
                dialog.setDeliveryColor(getColor(R.color.kitchenFontColor));
                dialog.setSortname("厨余垃圾");
                break;
            case 3:
                //其他垃圾
                dialog.setIcon(R.string.otherFont);
                dialog.setCardVieDgColor(getColor(R.color.otherFontColor));
                dialog.setIconColor(getColor(R.color.otherFontColor));
                dialog.setSortNameColor(getColor(R.color.otherFontColor));
                dialog.setChangJianColor(getColor(R.color.otherFontColor));
                dialog.setDeliveryColor(getColor(R.color.otherFontColor));
                dialog.setSortname("其他垃圾");
                break;
            default:
                break;
        }
        dialog.show();
    }
}
