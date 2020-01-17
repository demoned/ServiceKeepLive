package com.demons.servicekeeplive;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.demons.alivelibrary.DaemonEnv;
import com.demons.alivelibrary.IntentWrapper;

public class MainActivity extends Activity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        TraceServiceImpl.sShouldStopService = false;
        DaemonEnv.startServiceMayBind(TraceServiceImpl.class);

        IntentWrapper.whiteListMatters(this, "轨迹跟踪服务的持续运行");
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:

                break;
            case R.id.btn_white:

                break;
            case R.id.btn_stop:
                TraceServiceImpl.stopService();
                break;
        }
    }

    //防止华为机型未加入白名单时按返回键回到桌面再锁屏后几秒钟进程被杀
    public void onBackPressed() {
        IntentWrapper.onBackPressed(this);
    }
}
