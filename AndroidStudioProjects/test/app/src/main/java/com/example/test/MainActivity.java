package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

//    private String[] data={"apple","banana","orange",
//            "pear","mango","grape","apple","banana",
//            "orange","pear","mango","grape","apple",
//            "banana","orange","pear","mango","grape",
//            "apple","banana","orange","pear","mango","grape"};

    private List<Fruit> fruits=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
//        ListView listView=findViewById(R.id.listView);
//        listView.setAdapter(adapter);
            initFruits();
            FriutAdapter adapter=new FriutAdapter(MainActivity.this,R.layout.listview_layout,fruits);
            ListView listView=findViewById(R.id.listView);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Fruit fruit=fruits.get(position);
                    Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
                }
            });


    }

    private void initFruits() {
        for (int i=0;i<2;i++){
            Fruit apple=new Fruit("apple",R.drawable.apple);
            fruits.add(apple);
            Fruit caomei=new Fruit("caomei",R.drawable.caomei);
            fruits.add(caomei);
            Fruit huluobu=new Fruit("huluobu",R.drawable.huluobu);
            fruits.add(huluobu);
            Fruit mango=new Fruit("mango",R.drawable.mango);
            fruits.add(mango);
            Fruit xiangjiao=new Fruit("xiangjiao",R.drawable.xiangjiao);
            fruits.add(xiangjiao);
            Fruit yingtao=new Fruit("yingtao",R.drawable.yigtao);
            fruits.add(yingtao);



        }
    }

}

