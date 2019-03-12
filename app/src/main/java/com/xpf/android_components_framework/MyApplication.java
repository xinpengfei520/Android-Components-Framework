package com.xpf.android_components_framework;

import android.app.Application;

import com.xpf.routermodule.RouterModule;

/**
 * Created by x-sir on 2019/3/11 :)
 * Function:
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RouterModule.init(this, isDebug());
    }

    private boolean isDebug() {
        return BuildConfig.DEBUG;
    }
}
