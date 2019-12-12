package com.item.testproject2.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.item.testproject2.IconFont.FontIconView;
import com.item.testproject2.R;
import com.item.testproject2.Utils.ImageUtils;
import com.item.testproject2.activity.RecoveryActivity;
import com.item.testproject2.adapter.KePuAdapter;
import com.item.testproject2.pojo.Article;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener{
    Intent intent;
    private FontIconView center_ar_icon;
    private FontIconView center_voice_icon;
    private FontIconView center_recovery_icon;
    private List<Article> articleList;
    private RecyclerView recyclerView;
    private KePuAdapter kePuAdapter;

    public HomeFragment() {
    }
    public void init(){

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

        articleList=new ArrayList<>();
        recyclerView=view.findViewById(R.id.kepu_RecyclerView);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);//添加垂直布局
        recyclerView.setLayoutManager(manager);//将线性布局管理器添加到recyclerview中
        kePuAdapter=new KePuAdapter(articleList);//实例化适配器
        recyclerView.setAdapter(kePuAdapter);//添加适配器
        return view;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.center_ar_icon:
                Toast.makeText(getActivity(),"点击了AR识别",Toast.LENGTH_SHORT).show();
                break;
            case R.id.center_voice_icon:
                Toast.makeText(getActivity(),"点击了语音识别",Toast.LENGTH_SHORT).show();
                break;
            case  R.id.center_recovery_icon:
                intent=new Intent(getActivity(), RecoveryActivity.class);
                startActivity(intent);
                break;
                default:break;
        }
    }
}
