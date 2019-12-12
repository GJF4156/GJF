package com.item.week11_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText savEdit;
    EditText getEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        savEdit = findViewById(R.id.username);
        getEdit = findViewById(R.id.get_text);
        Button saveBtn = findViewById(R.id.save_btn);
        Button getBtn = findViewById(R.id.get_btn);

        saveBtn.setOnClickListener(this);
        getBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_btn:
                String inputData = savEdit.getText().toString();
                save(inputData);
                break;
            case R.id.get_btn:
                String getData=load();
                if (!TextUtils.isEmpty(getData)){
                    getEdit.setText(getData);
                    getEdit.setSelection(getData.length());
                }
                break;
                default:break;
        }
    }

    public void save(String inputText) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public String load(){
        FileInputStream in=null;
        BufferedReader reader=null;
        StringBuilder content=new StringBuilder();
        try {
            in=openFileInput("data");
            reader=new BufferedReader(new InputStreamReader(in));
            String line="";
            while ((line=reader.readLine())!=null){
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

                if (reader != null) {
                    try {
                        reader.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
        }
        return content.toString();
    }
}
