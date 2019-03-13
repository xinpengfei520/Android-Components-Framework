package com.xpf.routermodule;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.tencent.bugly.crashreport.CrashReport;
import com.xpf.basemodule.BaseModule;

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

        // 初始化 BaseModule
        BaseModule.init(isDebug);

        /*
         * 第三个参数为 SDK 调试模式开关，调试模式的行为特性如下：
         * 输出详细的 Bugly SDK 的 Log；
         * 每一条 Crash 都会被立即上报；
         * 自定义日志将会在 Logcat 中输出。
         * 建议在测试阶段建议设置成 true，发布时设置为 false
         */
        CrashReport.initCrashReport(application, "73a8058df1", isDebug);
    }
}
