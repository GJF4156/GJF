package com.item.testproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Goods> goodsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initGoods();
        RecyclerView recyclerView=findViewById(R.id.recycle_view);
        StaggeredGridLayoutManager staggeredGridLayoutManager=
                new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        GoodsAdapter adapter=new GoodsAdapter(goodsList);
        recyclerView.setAdapter(adapter);
    }
    private void initGoods(){
        for (int i=0;i<2;i++){
            Goods goods1=new Goods(getRandomLengthName("商品1"),R.drawable.img01);
            goodsList.add(goods1);
            Goods goods2=new Goods(getRandomLengthName("商品2"),R.drawable.img02);
            goodsList.add(goods2);
            Goods goods3=new Goods(getRandomLengthName("商品3"),R.drawable.img03);
            goodsList.add(goods3);
            Goods goods4=new Goods(getRandomLengthName("商品4"),R.drawable.img04);
            goodsList.add(goods4);
            Goods goods5=new Goods(getRandomLengthName("商品5"),R.drawable.img05);
            goodsList.add(goods5);
            Goods goods6=new Goods(getRandomLengthName("商品6"),R.drawable.img06);
            goodsList.add(goods6);
            Goods goods7=new Goods(getRandomLengthName("商品7"),R.drawable.img07);
            goodsList.add(goods7);
            Goods goods8=new Goods(getRandomLengthName("商品8"),R.drawable.img08);
            goodsList.add(goods8);
            Goods goods9=new Goods(getRandomLengthName("商品9"),R.drawable.img09);
            goodsList.add(goods9);
            Goods goods10=new Goods(getRandomLengthName("商品10"),R.drawable.img10);
            goodsList.add(goods10);
        }
    }
    private String getRandomLengthName(String name){
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<length;i++){
            builder.append(name);
        }
        return builder.toString();
    }
}
