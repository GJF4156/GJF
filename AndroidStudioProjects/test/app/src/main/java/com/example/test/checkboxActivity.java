package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class checkboxActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private CheckBox checkboxOne;
    private CheckBox checkboxTwo;
    private CheckBox checkboxThree;
    private Button btn_checkbox;
    private ImageButton img_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox);
        RadioGroup radgroup = (RadioGroup) findViewById(R.id.radioGroup);
        //第一种获得单选按钮值的方法
        //为radioGroup设置一个监听器:setOnCheckedChanged()
        img_btn=findViewById(R.id.img_btn);
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "这是一个imagebutton" , Toast.LENGTH_LONG).show();
            }
        });
        radgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radbtn = (RadioButton) findViewById(checkedId);
                Toast.makeText(getApplicationContext(), "按钮组值发生改变,你选了" + radbtn.getText(), Toast.LENGTH_LONG).show();
            }
        });

        checkboxOne = (CheckBox) findViewById(R.id.checkboxOne);
        checkboxTwo = (CheckBox) findViewById(R.id.checkboxTwo);
        checkboxThree = (CheckBox) findViewById(R.id.checkboxThree);
        btn_checkbox = (Button) findViewById(R.id.btn_checkbox);

        checkboxOne.setOnCheckedChangeListener(this);
        checkboxTwo.setOnCheckedChangeListener(this);
        checkboxThree.setOnCheckedChangeListener(this);
        btn_checkbox.setOnClickListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(compoundButton.isChecked()) Toast.makeText(this,compoundButton.getText().toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        String choose = "";
        if(checkboxOne.isChecked())choose += checkboxOne.getText().toString() + "";
        if(checkboxTwo.isChecked())choose += checkboxTwo.getText().toString() + "";
        if(checkboxThree.isChecked())choose += checkboxThree.getText().toString() + "";
        Toast.makeText(this,choose,Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

