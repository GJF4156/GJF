package com.item.testproject4;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;
    public MusicService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw null;
    }
    @Override
    public void onCreate() {
        //播放本地资源的音乐
        mediaPlayer=MediaPlayer.create(this,R.raw.last_stop);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaPlayer.start();
            }
        });
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}
