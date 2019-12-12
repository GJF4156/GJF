package com.item.example;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
public class AsyncTaskActivity extends AppCompatActivity implements View.OnClickListener {
    private Button laoding;
    private Button canser;
    private TextView mytext;
    private ProgressBar progressBar;
    private LoadTask myTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        laoding = findViewById(R.id.loading);
        canser = findViewById(R.id.canser);
        mytext = findViewById(R.id.mytext);
        myTask = new LoadTask();
        progressBar=findViewById(R.id.progress_bar);
        laoding.setOnClickListener(this);
        canser.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loading:
                myTask.execute();
                break;
            case R.id.canser:
                myTask.cancel(true);
                break;
        }
    }
    private class LoadTask extends AsyncTask<Void, Integer, Boolean> {
        @Override
        protected void onPreExecute() {
            mytext.setText("It's loading......");
        }
        @Override
        protected void onPostExecute(Boolean aBoolean) {
            mytext.setText("loading end!");
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0]);
            mytext.setText("loading..." + values[0] + "%");
        }
        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                int count = 0;
                int step = 2;
                while (count < 100) {
                    count += step;
                    publishProgress(count);
                    Thread.sleep(50);
                }
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        @Override
        protected void onCancelled() {
            mytext.setText("取消加载！");
            progressBar.setProgress(0);
        }
    }
}
