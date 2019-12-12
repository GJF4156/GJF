package com.item.example;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class CameraAlbumActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int TAKE_PHOTO=1;
    private ImageView picture;
    private Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_album);

        Button takePhoto=findViewById(R.id.take_photo);
        takePhoto.setOnClickListener(this);
        picture=findViewById(R.id.photo_image);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.take_photo:
                if (ContextCompat.checkSelfPermission(CameraAlbumActivity.this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(CameraAlbumActivity.this,new String[]{Manifest.permission.CAMERA},1);
                }else{
                    openCamera();
                }
                break;
                default:break;
        }
    }

    private void openCamera() {
        File outputImage=new File(getExternalCacheDir(),"output_image.jpg");
        try{
            if (outputImage.exists()){
                outputImage.delete();
            }
            outputImage.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
        try {
            if (Build.VERSION.SDK_INT>=24){
                imageUri= FileProvider.getUriForFile(CameraAlbumActivity.this,"com.item.example.fileprovider",outputImage);
            }else{
                imageUri=Uri.fromFile(outputImage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
        startActivityForResult(intent,TAKE_PHOTO);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    openCamera();
                }else {
                    Toast.makeText(CameraAlbumActivity.this,"你关闭了权限请求",Toast.LENGTH_SHORT).show();
                }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK){
                    try{
                        Bitmap bitmap=BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        picture.setImageBitmap(bitmap);
                    }catch (Exception e){e.printStackTrace();}
                }
                break;
                default:break;
        }
    }
}
