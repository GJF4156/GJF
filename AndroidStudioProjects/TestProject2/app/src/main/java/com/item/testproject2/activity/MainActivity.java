package com.item.testproject2.activity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.item.testproject2.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences pref;
    private EditText account;
    private EditText pwd;
    private Button login;
    private Button regist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        account = findViewById(R.id.user);
        pwd = findViewById(R.id.pwd);
        login = findViewById(R.id.login);
        regist = findViewById(R.id.regist);
        regist.setOnClickListener(this);
        login.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String user = account.getText().toString();
        String password = pwd.getText().toString();
        switch (v.getId()) {
            case R.id.login:
                pref=getSharedPreferences("account",MODE_PRIVATE);
                String name=pref.getString("user","");
                String pwd=pref.getString("password","");
                if (user.equals(name) && password.equals(pwd)){
                    Intent intent=new Intent(MainActivity.this,BottomBarActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this, "账号密码不存在或账号密码错误！", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.regist:
                if (user!=null && user!="" && password!=null && password!="") {
                    SharedPreferences.Editor editor = getSharedPreferences("account", MODE_PRIVATE).edit();
                    editor.putString("user", user);
                    editor.putString("password", password);
                    editor.apply();
                    Toast.makeText(MainActivity.this, "用户注册成功！", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}
