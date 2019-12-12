package com.item.example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GalleryActivity extends AppCompatActivity {
    private LinearLayout myGallery;
    private int[] myImagesId;
    private LayoutInflater myInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        myInflater=LayoutInflater.from(GalleryActivity.this);
        initData();
        initView();

    }

    private void initData(){
        myImagesId=new int[]{R.drawable.kehuishoulaji,
                R.drawable.qitalaji,
                R.drawable.youhailaji,
                R.drawable.chuyulaji};  //照片都放在drawable文件夹下
    }

    private void initView(){
        myGallery=findViewById(R.id.image_gallery);
        for(int i=0;i<myImagesId.length;i++){
            View view=myInflater.inflate(R.layout.gallery_item, myGallery,false); //使用inflate获取phtoview布局里面的myGallery视窗
            ImageView img=view.findViewById(R.id.imageview_1);
            img.setImageResource(myImagesId[i]);
            myGallery.addView(view);  //把添加过资源后的view视图重新添加到myGallery中
        }
    }

}
