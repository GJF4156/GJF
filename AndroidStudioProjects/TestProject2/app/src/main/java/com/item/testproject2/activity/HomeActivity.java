package com.item.testproject2.activity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.item.testproject2.R;
import com.item.testproject2.adapter.KePuAdapter;
import com.item.testproject2.pojo.Article;
import com.item.testproject2.pojo.Constants.Constant;
import com.item.testproject2.pojo.services.ArticleService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    private ImageView mainImage;
    private List<Article> articleList;
    private RecyclerView recyclerView;
    private KePuAdapter kePuAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        init();
    }
    public void init(){
        mainImage=findViewById(R.id.main_image);
        articleList=new ArrayList<>();
        recyclerView=findViewById(R.id.kepu_RecyclerView);
        request();
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);//添加垂直布局
        recyclerView.setLayoutManager(manager);//将线性布局管理器添加到recyclerview中
        kePuAdapter=new KePuAdapter(articleList);//实例化适配器
        recyclerView.setAdapter(kePuAdapter);//添加适配器
    }
    public void request(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;
        ArticleService articleService=retrofit.create(ArticleService.class);
        Call<Article> call=articleService.articles();
        call.enqueue(new Callback<Article>() {
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {
                Article article=response.body();
                articleList.add(article);
            }
            @Override
            public void onFailure(Call<Article> call, Throwable t) {
            }
        });
    }



}
