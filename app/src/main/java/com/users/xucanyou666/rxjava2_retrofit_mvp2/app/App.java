package com.users.xucanyou666.rxjava2_retrofit_mvp2.app;

import android.app.Application;

import com.yechaoa.yutils.ActivityUtil;
import com.yechaoa.yutils.LogUtil;
import com.yechaoa.yutils.YUtils;

/**
 * Description : App
 *
 * @author XuCanyou666
 * @date 2020/2/8
 */


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        YUtils.initialize(this);
        //设置打印开关
        LogUtil.setIsLog(true);
        //注册Activity生命周期
        registerActivityLifecycleCallbacks(ActivityUtil.getActivityLifecycleCallbacks());
    }

}
