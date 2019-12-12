package com.item.week11_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPres extends AppCompatActivity implements View.OnClickListener {
    private Button saveBtn;
    private Button getBtn;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pres);
        saveBtn=findViewById(R.id.save_btn);
        getBtn=findViewById(R.id.getBtn);
        textView=findViewById(R.id.textview);
        saveBtn.setOnClickListener(this);
        getBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.save_btn:
            SharedPreferences.Editor editor=getSharedPreferences("sharedPres",MODE_PRIVATE).edit();
            editor.putString("name","小唐");
            editor.putInt("age",22);
            editor.apply();
            break;
            case R.id.getBtn:
                SharedPreferences pref=getSharedPreferences("sharedPres",MODE_PRIVATE);
                String name=pref.getString("name","");
                textView.setText(name);
                break;
                default:break;
        }
    }
}
