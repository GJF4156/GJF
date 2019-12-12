package com.item.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AudioActivity extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer mediaPlayer=new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        Button play=findViewById(R.id.play);
        Button stop=findViewById(R.id.stop);
        Button pause=findViewById(R.id.pause);
        play.setOnClickListener(this);
        stop.setOnClickListener(this);
        pause.setOnClickListener(this);
        if (ContextCompat.checkSelfPermission(AudioActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(AudioActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        }else {
            initMediaPlayer();
        }
    }

    private void initMediaPlayer() {

    }

    @Override
    public void onClick(View v) {

    }
}
