package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp.UI.mvpView;
import com.example.mvp.beans.NewsData;
import com.example.mvp.pres.mvpPres;
import com.example.mvp.pres.mvpPresImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity  implements mvpView{
    private TextView text;
    private mvpPres mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.text1);
        mPresenter=new mvpPresImpl(this);
        mPresenter.getData();
        Toast.makeText(MainActivity.this,"hahahah",Toast.LENGTH_SHORT).show();
    }

        @Override
    public void getData(List<NewsData.DatalistBean> newslistBeanList) {
        text.setText(newslistBeanList.get(0).getGname());
    }
}
