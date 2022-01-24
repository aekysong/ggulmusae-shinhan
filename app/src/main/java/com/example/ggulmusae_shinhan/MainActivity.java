package com.example.ggulmusae_shinhan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    DbHandler dbHandler;
    public static Handler threadHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_test);

        // 테스트 API
        dbHandler = new DbHandler();
        dbHandler.setDbParams(String.valueOf("user"), String.valueOf("READ"));
        Thread dbThread = new Thread(dbHandler);
        dbThread.start();
    }
}
