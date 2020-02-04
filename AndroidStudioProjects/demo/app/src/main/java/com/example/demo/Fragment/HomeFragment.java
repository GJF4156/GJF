package com.example.demo.Fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.demo.IconFont.FontIconView;
import com.example.demo.R;
import com.example.demo.RecoveryActivity;
import com.example.demo.Utils.ImageUtils;
import com.example.demo.activity.SpeachActivity;

public class HomeFragment extends Fragment implements View.OnClickListener{
    private Intent intent;
    private FontIconView center_ar_icon;
    private FontIconView center_voice_icon;
    private FontIconView center_recovery_icon;

    public HomeFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ImageView imageView = view.findViewById(R.id.main_image);
        center_ar_icon=view.findViewById(R.id.center_ar_icon);
        center_voice_icon=view.findViewById(R.id.center_voice_icon);
        center_recovery_icon=view.findViewById(R.id.center_recovery_icon);
        center_ar_icon.setOnClickListener(this);
        center_voice_icon.setOnClickListener(this);
        center_recovery_icon.setOnClickListener(this);
        Drawable drawable = getActivity().getDrawable(R.mipmap.main);
        //将Drawable转化为Bitmap
        Bitmap bitmap = ImageUtils.drawableToBitmap(drawable);
        //获取圆角图片
        Bitmap roundBitmap = ImageUtils.getRoundedCornerBitmap(bitmap, 25.0f);
        imageView.setImageBitmap(roundBitmap);
        return view;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.center_ar_icon:
                Toast.makeText(getActivity(),"点击了AR识别",Toast.LENGTH_SHORT).show();
                break;
            case R.id.center_voice_icon:
                startActivity(new Intent(getActivity(), SpeachActivity.class));
                break;
            case  R.id.center_recovery_icon:
                intent=new Intent(getActivity(), RecoveryActivity.class);
                startActivity(intent);
                break;
            default:break;
        }
    }
}

