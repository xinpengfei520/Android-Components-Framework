package com.xpf.basemodule;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.tencent.bugly.crashreport.CrashReport;
import com.xpf.basemodule.util.LogCatStrategy;
import com.xpf.basemodule.util.LogUtils;

/**
 * Created by x-sir on 2019/3/12 :)
 * Function:BaseApplication 所有单独可运行 Module 的基类，进行一些初始化操作
 */
public abstract class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initARouter();
        initBugly();
        initLogger();
    }

    /**
     * Initialize the ARouter SDK
     */
    public void initARouter() {
        // These two lines must be written before init, otherwise these configurations will be
        // invalid in the init process
        if (isDebug()) {
            // Print log
            ARouter.openLog();
            // Turn on debugging mode (If you are running in InstantRun mode, you must turn on debug
            // mode! Online version needs to be closed, otherwise there is a security risk)
            ARouter.openDebug();
        }

        // As early as possible, it is recommended to initialize in the Application
        ARouter.init(this);
    }

    private void initBugly() {
        /*
         * 第三个参数为 SDK 调试模式开关，调试模式的行为特性如下：
         * 输出详细的 Bugly SDK 的 Log；
         * 每一条 Crash 都会被立即上报；
         * 自定义日志将会在 Logcat 中输出。
         * 建议在测试阶段建议设置成 true，发布时设置为 false
         */
        CrashReport.initCrashReport(this, "73a8058df1", isDebug());
    }

    private void initLogger() {
        PrettyFormatStrategy strategy = PrettyFormatStrategy.newBuilder()
                .logStrategy(new LogCatStrategy())
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(strategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return isDebug();
            }
        });

        LogUtils.setIsNeedPrintLog(isDebug());
    }

    /**
     * 让子类自己去实现，是否是调试模式
     *
     * @return boolean result
     */
    public abstract boolean isDebug();
}
