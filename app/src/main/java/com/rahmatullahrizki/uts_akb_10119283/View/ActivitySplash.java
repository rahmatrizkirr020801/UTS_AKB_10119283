package com.rahmatullahrizki.uts_akb_10119283.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.rahmatullahrizki.uts_akb_10119283.MainActivity;
import com.rahmatullahrizki.uts_akb_10119283.R;

// selasa 7 juni 2022, 1011983, Rahmatullah Rizki, IF7

public class ActivitySplash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(ActivitySplash.this, MainActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}
