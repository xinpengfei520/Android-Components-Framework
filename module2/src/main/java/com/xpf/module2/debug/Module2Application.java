package com.xpf.module2.debug;

import com.xpf.basemodule.BaseApplication;
import com.xpf.module2.BuildConfig;

/**
 * Created by x-sir on 2019/3/13 :)
 * Function:
 */
public class Module2Application extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }
}
