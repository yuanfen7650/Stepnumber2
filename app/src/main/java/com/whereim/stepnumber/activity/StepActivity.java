package com.whereim.stepnumber.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ViewAnimationUtils;
import android.widget.TextView;

import com.whereim.stepnumber.R;
import com.whereim.stepnumber.bean.RecordBean;
import com.whereim.stepnumber.library.eventbus.EventBus;
import com.whereim.stepnumber.library.eventbus.EventBusSingle;
import com.whereim.stepnumber.library.eventbus.EventListener;
import com.whereim.stepnumber.manager.DbManager;
import com.whereim.stepnumber.utils.DbFactory;

/**
 * Created by HLD on 2015/7/13.
 */
public class StepActivity extends Activity implements EventListener{
    private TextView txtStep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBusSingle.register(this);
        setContentView(R.layout.activity_step);
        prepare();
    }
    @Override
    public void onEvent(Object obj) {

    }
    private void init(){
        long steps = DbFactory.queryTodayStepCount(this);
        txtStep.setText(""+steps);
    }
    private void prepare(){
        txtStep=(TextView)findViewById(R.id.txtStep);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusSingle.unregister(this);
    }
}