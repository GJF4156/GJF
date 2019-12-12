package com.item.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.item.example.beans.Constants;
import com.item.example.beans.User;
import com.item.example.beans.UserService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OkHttpActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testretrofit);

        Button button=findViewById(R.id.btn1);
        textView=findViewById(R.id.tv1);
        button.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;
        UserService userService=retrofit.create(UserService.class);
        Call<User> call=userService.login("gjf","111");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                textView.setText(response.body().getSex());
                Log.d("message",response.body().getUsername());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });


    }
}
