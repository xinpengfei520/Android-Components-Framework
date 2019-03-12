package com.xpf.routermodule;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by x-sir on 2019/3/12 :)
 * Function:ARouter SDK 初始化类
 */
public class RouterModule {

    /**
     * initialize alibaba ARouter sdk.
     *
     * @param application application object.
     * @param isDebug     is debug mode.
     */
    public static void init(Application application, boolean isDebug) {
        // Initialize the ARouter SDK

        // These two lines must be written before init, otherwise these configurations will be
        // invalid in the init process
        if (isDebug) {
            // Print log
            ARouter.openLog();
            // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug
            // mode! Online version needs to be closed, otherwise there is a security risk)
            ARouter.openDebug();
        }

        // As early as possible, it is recommended to initialize in the Application
        ARouter.init(application);
    }
}
