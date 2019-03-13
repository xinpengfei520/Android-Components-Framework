package com.xpf.mainmodule.debug;

import com.xpf.basemodule.BaseApplication;
import com.xpf.mainmodule.BuildConfig;

/**
 * Created by x-sir on 2019/3/13 :)
 * Function:
 */
public class MainModuleApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }
}
