package com.item.example;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int update_text=1;
    public static final int update_color=2;
    private TextView textView;
    private Button changebtn;
    private Button changebtn2;
    private Button changebtn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        textView=findViewById(R.id.textview);
        changebtn=findViewById(R.id.change_btn);
        changebtn2=findViewById(R.id.change2_btn);
        changebtn3=findViewById(R.id.change3_btn);
        changebtn.setOnClickListener(this);
        changebtn2.setOnClickListener(this);
        changebtn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.change_btn:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("hahahah");
                    }
                }).start();
                break;
            case R.id.change2_btn:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message=new Message();
                        message.what=update_text;
                        handler.sendMessage(message);
                    }
                }).start();
            case R.id.change3_btn:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message=new Message();
                        message.what=update_color;
                        handler.sendMessage(message);
                    }
                }).start();

                default:break;
        }
    }

   @SuppressLint("HandlerLeak")
   private Handler handler=new Handler(){
        @SuppressLint("ResourceAsColor")
        public void handleMessage(Message msg){
            switch (msg.what){
                case update_text:
                    textView.setText("嘿嘿嘿");
                    break;
                case update_color:
                    textView.setTextColor(Color.parseColor("#0000FF"));
                    break;
                    default:break;
            }
        }
   };

}
