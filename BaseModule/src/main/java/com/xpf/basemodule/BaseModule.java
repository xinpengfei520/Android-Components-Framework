package com.xpf.basemodule;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.xpf.basemodule.util.LogCatStrategy;
import com.xpf.basemodule.util.LogUtils;

/**
 * Created by x-sir on 2019/3/12 :)
 * Function:BaseModule 初始化类
 */
public class BaseModule {

    public static void init(final boolean isDebug) {
        PrettyFormatStrategy strategy = PrettyFormatStrategy.newBuilder()
                .logStrategy(new LogCatStrategy())
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(strategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return isDebug;
            }
        });

        LogUtils.setIsNeedPrintLog(isDebug);
    }
}
