package com.xpf.android_components_framework;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xpf.routermodule.cons.PathConstants;
import com.xpf.routermodule.util.RouterUtils;

/**
 * Created by x-sir on 2019/3/12 :)
 * Function:欢迎页面
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            RouterUtils.jumpToActivity(PathConstants.MAIN_MODULE_MAINACTIVITY);
            WelcomeActivity.this.finish();
        }, 2000);
    }
}
