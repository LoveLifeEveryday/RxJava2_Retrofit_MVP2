//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.users.xucanyou666.rxjava2_retrofit_mvp2.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Bundle;

import java.util.Stack;

/**
 * Description : ActivityUtil
 *
 * @author XuCanyou666
 * @date 2020/4/27
 */

@TargetApi(14)
public class ActivityUtil {
    private static Stack<Activity> activityStack = new Stack<>();
    private static final ActivityUtil.MyActivityLifecycleCallbacks instance = new ActivityUtil.MyActivityLifecycleCallbacks();

    public ActivityUtil() {
    }

    public static ActivityLifecycleCallbacks getActivityLifecycleCallbacks() {
        return instance;
    }

    public static void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
        }

    }


    /**
     * 不用 finish 当前 Activity 时直接调用此方法
     *
     * @param classes
     */
    public static void startActivity(Class classes) {
        startActivity(classes, false);
    }


    /**
     * 需要 finish 当前 Activity 时调用此方法，布尔值参数传入 true
     *
     * @param classes  需要打开的 activity
     * @param isFinish 是否 finish 当前 activity
     */
    public static void startActivity(Class classes, boolean isFinish) {
        Activity currentActivity = getCurrentActivity();
        Intent intent = new Intent(currentActivity, classes);
        currentActivity.startActivity(intent);
        if (isFinish) {
            finishActivity(currentActivity);
        }
    }


    /**
     * 关闭所有 Activity
     */
    public static void closeAllActivity() {
        while (true) {
            Activity activity = getCurrentActivity();
            if (null == activity) {
                return;
            }
            finishActivity(activity);
        }
    }

    /**
     * 得到当前的 Activity
     *
     * @return 当前 Activity
     */
    public static Activity getCurrentActivity() {
        Activity activity = null;
        if (!activityStack.isEmpty()) {
            activity = activityStack.peek();
        }
        return activity;
    }


    private static class MyActivityLifecycleCallbacks implements ActivityLifecycleCallbacks {
        private MyActivityLifecycleCallbacks() {
        }

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            ActivityUtil.activityStack.remove(activity);
            ActivityUtil.activityStack.push(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {
        }

        @Override
        public void onActivityResumed(Activity activity) {
        }

        @Override
        public void onActivityPaused(Activity activity) {
        }

        @Override
        public void onActivityStopped(Activity activity) {
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            ActivityUtil.activityStack.remove(activity);
        }
    }
}
