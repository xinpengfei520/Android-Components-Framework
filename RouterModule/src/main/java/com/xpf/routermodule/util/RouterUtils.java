package com.xpf.routermodule.util;

import android.app.Activity;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by x-sir on 2019/3/12 :)
 * Function:路由页面跳转工具类的封装
 */
public class RouterUtils {

    /**
     * 普通跳转(不携带参数)
     *
     * @param path 跳转的路径
     */
    public static void jumpToActivity(String path) {
        ARouter.getInstance().build(path).navigation();
    }

    /**
     * 携带参数跳转
     *
     * @param path 跳转的路径
     * @param tag  数据标记
     * @param data 数据
     */
    public static void jumpToActivityWithParam(String path, String tag, String data) {
        ARouter.getInstance()
                .build(path)
                .withString(tag, data)
                .navigation();
    }

    /**
     * 带回调的启动
     *
     * @param path        跳转的路径
     * @param activity    activity 实例
     * @param requestCode 请求码
     */
    public static void jumpToActivityWithCallback(String path, Activity activity, int requestCode) {
        ARouter.getInstance()
                .build(path)
                .navigation(activity, requestCode);
    }

    /**
     * 同时带参数、带回调的启动
     *
     * @param path        跳转的路径
     * @param tag         数据标记
     * @param data        数据
     * @param activity    activity 实例
     * @param requestCode 请求码
     */
    public static void jumpToActivityWithParamAndCallback(String path, String tag, String data, Activity activity, int requestCode) {
        ARouter.getInstance()
                .build(path)
                .withString(tag, data)
                .navigation(activity, requestCode);
    }
}
