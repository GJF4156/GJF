package com.item.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

public class ServicesActivity extends AppCompatActivity implements View.OnClickListener {

    String chanerId="1";

    private MyService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        Button startService = findViewById(R.id.start_service);
        Button stopService = findViewById(R.id.stop_service);
        Button bindService = findViewById(R.id.bind_service);
        Button unbindService = findViewById(R.id.unbind_service);
        Button startNotice=findViewById(R.id.start_notice);
        startNotice.setOnClickListener(this);
        bindService.setOnClickListener(this);
        unbindService.setOnClickListener(this);
        startService.setOnClickListener(this);
        stopService.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_service:
                startService(new Intent(this, MyService.class));
                break;
            case R.id.stop_service:
                stopService(new Intent(this, MyService.class));
                break;
            case R.id.bind_service:
                bindService(new Intent(this, MyService.class), connection, BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                unbindService(connection);
                break;
            case R.id.start_notice:

                Intent intent=new Intent(this,NotificationActivity.class);
                PendingIntent pi=PendingIntent.getActivities(this,0, new Intent[]{intent},0);
                NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
                    NotificationChannel notificationChannel=
                            new NotificationChannel(chanerId,"name",NotificationManager.IMPORTANCE_HIGH);
                    manager.createNotificationChannel(notificationChannel);
                }
                Notification notification=new NotificationCompat.Builder(this,chanerId)
                        .setContentTitle("标题")
                        .setContentText("这是一个消息通知内容")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pi)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                        .build();
                manager.notify(1,notification);
            default:
                break;
        }
    }
}
