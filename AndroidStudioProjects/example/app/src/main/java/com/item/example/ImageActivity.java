package com.item.example;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.item.example.Utils.ImageUtils;

public class ImageActivity extends AppCompatActivity {


    private ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_image);
        setupViews();
    }

    private void setupViews(){
        imageView1 =findViewById(R.id.image01);

        //获取壁纸返回值是Drawable
        Drawable drawable = getDrawable(R.drawable.main2);
        //将Drawable转化为Bitmap
        Bitmap bitmap = ImageUtils.drawableToBitmap(drawable);
        //缩放图片
       Bitmap zoomBitmap = ImageUtils.zoomBitmap(bitmap, 700, 400);
        //获取圆角图片
        Bitmap roundBitmap = ImageUtils.getRoundedCornerBitmap(zoomBitmap, 25.0f);
        //获取倒影图片
        Bitmap reflectBitmap = ImageUtils.createReflectionImageWithOrigin(zoomBitmap);
        //这里可以让Bitmap再转化为Drawable
//   Drawable roundDrawable = new BitmapDrawable(roundBitmap);
//   Drawable reflectDrawable = new BitmapDrawable(reflectBitmap);
//   mImageView01.setBackgroundDrawable(roundDrawable);
//   mImageView02.setBackgroundDrawable(reflectDrawable);
        imageView1.setImageBitmap(roundBitmap);
    }
}
