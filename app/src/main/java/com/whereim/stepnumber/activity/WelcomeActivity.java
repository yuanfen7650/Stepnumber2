package com.whereim.stepnumber.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.whereim.stepnumber.AppActivity;
import com.whereim.stepnumber.R;
import com.whereim.stepnumber.service.MonitorService;

/**
 * Created by HLD on 2015/7/16.
 */
public class WelcomeActivity extends AppActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Intent intent=new Intent(this, MonitorService.class);
        startService(intent);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(WelcomeActivity.this,StepActivity.class);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        },1000);
    }
}
