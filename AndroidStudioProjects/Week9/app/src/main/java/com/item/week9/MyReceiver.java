package com.item.week9;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        String msg=intent.getStringExtra("Msg");
//        Log.d(TAG,msg);
        Log.d("data","这是一个日志");
        Toast.makeText(context,"hahahahahahah",Toast.LENGTH_SHORT).show();

    }
}
