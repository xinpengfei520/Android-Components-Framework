package com.xpf.android_components_framework;

import com.xpf.basemodule.BaseApplication;

/**
 * Created by x-sir on 2019/3/11 :)
 * Function:
 */
public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }
}
