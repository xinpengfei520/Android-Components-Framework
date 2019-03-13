package com.xpf.module1.debug;

import com.xpf.basemodule.BaseApplication;
import com.xpf.module1.BuildConfig;

/**
 * Created by x-sir on 2019/3/13 :)
 * Function:
 */
public class Module1Application extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }
}
