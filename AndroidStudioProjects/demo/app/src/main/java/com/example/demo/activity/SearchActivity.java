package com.example.demo.activity;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.example.demo.adapter.RvAdapter;
import com.example.demo.base.BaseActivity;
import com.example.demo.beans.SortsBean;
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
        mStrs = sortsBean.getNewslist();
//        Log.d("TAG","===============\n\n\n"+mStrs);
        //设置recyclerview的适配器，并设置点击事件
        recyclerView.setAdapter(new RvAdapter(SearchActivity.this, mStrs, new RvAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(SearchActivity.this, mStrs.get(position).getExplain(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    //recyclerview添加分割线的类
    public class DividerItemDecoration extends RecyclerView.ItemDecoration {
        private final int[] ATTRS = new int[]{
                android.R.attr.listDivider
        };

        public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
        public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

        private Drawable mDivider;
        private int mOrientation;

        public DividerItemDecoration(Context context, int orientation) {
            final TypedArray a = context.obtainStyledAttributes(ATTRS);
            mDivider = a.getDrawable(0);
            setOrientation(orientation);
        }

        private void setOrientation(int orientation) {
            if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
                throw new IllegalArgumentException("invaild orientation");
            }
            mOrientation = orientation;
        }

        @Override
        public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            if (mOrientation == VERTICAL_LIST) {
                drawVertical(c, parent);
            } else {
                drawHorizontal(c, parent);
            }
        }

        private void drawHorizontal(Canvas c, RecyclerView parent) {
            final int top = parent.getPaddingTop();
            final int bottom = parent.getHeight() - parent.getPaddingBottom();
            final int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                final int left = child.getRight() + params.rightMargin;
                final int right = left + mDivider.getIntrinsicWidth();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }

        private void drawVertical(Canvas c, RecyclerView parent) {
            final int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();
            final int childCound = parent.getChildCount();
            for (int i = 0; i < childCound; i++) {
                final View child = parent.getChildAt(i);
                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                final int top = child.getBottom() + params.bottomMargin;
                final int bottom = top + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            if (mOrientation == VERTICAL_LIST) {
                outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
            } else {
                outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
            }
        }
    }
}
