package com.users.xucanyou666.rxjava2_retrofit_mvp2.util;


/**
 * @Author xucanyou666
 * @Date 2020/4/27 09:28
 * email：913710642@qq.com
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import android.util.Log;

public class LogUtil {
    private static String TAG = "LogUtil";
    private static boolean IS_LOG = false;
    private static int MAX_LENGTH = 4000;

    public LogUtil() {
    }

    public static void setIsLog(boolean isLog) {
        IS_LOG = isLog;
    }

    public static void setIsLog(boolean isLog, String tag) {
        TAG = tag;
        IS_LOG = isLog;
    }

    public static void i(String msg) {
        if (IS_LOG) {
            String[] info = getAutoJumpLogInfos();
            int strLength = msg.length();
            int start = 0;
            int end = MAX_LENGTH;

            for (int i = 0; i < 100; ++i) {
                if (strLength <= end) {
                    Log.i(TAG, info[1] + info[2] + " --->> " + msg.substring(start, strLength));
                    break;
                }

                Log.i(TAG, info[1] + info[2] + " --->> " + msg.substring(start, end));
                start = end;
                end += MAX_LENGTH;
            }
        }

    }

    public static void i(String TAG, String msg) {
        if (IS_LOG) {
            String[] info = getAutoJumpLogInfos();
            int strLength = msg.length();
            int start = 0;
            int end = MAX_LENGTH;

            for (int i = 0; i < 100; ++i) {
                if (strLength <= end) {
                    Log.i(TAG, info[1] + info[2] + " --->> " + msg.substring(start, strLength));
                    break;
                }

                Log.i(TAG, info[1] + info[2] + " --->> " + msg.substring(start, end));
                start = end;
                end += MAX_LENGTH;
            }
        }

    }

    public static void d(String msg) {
        if (IS_LOG) {
            String[] info = getAutoJumpLogInfos();
            int strLength = msg.length();
            int start = 0;
            int end = MAX_LENGTH;

            for (int i = 0; i < 100; ++i) {
                if (strLength <= end) {
                    Log.d(TAG, info[1] + info[2] + " --->> " + msg.substring(start, strLength));
                    break;
                }

                Log.d(TAG, info[1] + info[2] + " --->> " + msg.substring(start, end));
                start = end;
                end += MAX_LENGTH;
            }
        }

    }

    public static void d(String TAG, String msg) {
        if (IS_LOG) {
            String[] info = getAutoJumpLogInfos();
            int strLength = msg.length();
            int start = 0;
            int end = MAX_LENGTH;

            for (int i = 0; i < 100; ++i) {
                if (strLength <= end) {
                    Log.d(TAG, info[1] + info[2] + " --->> " + msg.substring(start, strLength));
                    break;
                }

                Log.d(TAG, info[1] + info[2] + " --->> " + msg.substring(start, end));
                start = end;
                end += MAX_LENGTH;
            }
        }

    }

    public static void e(String msg) {
        if (IS_LOG) {
            String[] info = getAutoJumpLogInfos();
            int strLength = msg.length();
            int start = 0;
            int end = MAX_LENGTH;

            for (int i = 0; i < 100; ++i) {
                if (strLength <= end) {
                    Log.e(TAG, info[1] + info[2] + " --->> " + msg.substring(start, strLength));
                    break;
                }

                Log.e(TAG, info[1] + info[2] + " --->> " + msg.substring(start, end));
                start = end;
                end += MAX_LENGTH;
            }
        }

    }

    public static void e(String TAG, String msg) {
        if (IS_LOG) {
            String[] info = getAutoJumpLogInfos();
            int strLength = msg.length();
            int start = 0;
            int end = MAX_LENGTH;

            for (int i = 0; i < 100; ++i) {
                if (strLength <= end) {
                    Log.e(TAG, info[1] + info[2] + " --->> " + msg.substring(start, strLength));
                    break;
                }

                Log.e(TAG, info[1] + info[2] + " --->> " + msg.substring(start, end));
                start = end;
                end += MAX_LENGTH;
            }
        }

    }

    private static String[] getAutoJumpLogInfos() {
        String[] infos = new String[]{"", "", ""};
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        infos[0] = elements[4].getClassName().substring(elements[4].getClassName().lastIndexOf(".") + 1);
        infos[1] = elements[4].getMethodName();
        infos[2] = "(" + elements[4].getFileName() + ":" + elements[4].getLineNumber() + ")";
        return infos;
    }
}
