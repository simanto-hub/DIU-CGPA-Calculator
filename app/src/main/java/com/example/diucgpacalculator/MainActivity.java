package com.example.diucgpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progress_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBarID);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                goHomeActivity();
            }
        });
        thread.start();

    }

    private void goHomeActivity() {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    private void doWork() {

        for(progress_value =20; progress_value<=100; progress_value = progress_value+40){
            try {
                Thread.sleep(1000);
                progressBar.setProgress(progress_value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}