package com.item.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.item.example.adapter.IconTextAdapter;
import com.item.example.adapter.TabBarAdapter;
import com.item.example.beans.IconText;
import com.item.example.fragment.HomeFragment;
import com.item.example.fragment.MeFragment;
import com.item.example.fragment.ShopFragment;
import com.item.example.fragment.SortFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<IconText> iconList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        IconTextAdapter adapter=new IconTextAdapter(iconList);
        recyclerView.setAdapter(adapter);
        adapter.setCusClickListener(new IconTextAdapter.addClickListerner() {
            @Override
            public void addClick(int position) {
                switch (position){
                    case 0:
                        Toast.makeText(MainActivity.this,"你点击了0",Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this,"你点击了"+position,Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this,"你点击了"+position,Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
    private void init(){
        IconText iconText=new IconText(R.string.AR,"扫一扫");
        IconText iconText1=new IconText(R.string.yuying,"语音识别");
        IconText iconText2=new IconText(R.string.huishou,"回收站");
        iconList.add(iconText);
        iconList.add(iconText1);
        iconList.add(iconText2);
    }
}
