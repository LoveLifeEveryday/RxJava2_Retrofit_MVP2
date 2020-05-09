package com.users.xucanyou666.rxjava2_retrofit_mvp2.util;


import android.content.SharedPreferences;

/**
 * @Author xucanyou666
 * @Date 2020/4/27 11:38
 * email：913710642@qq.com
 */
public class SpUtil {
    private static final String FILE_NAME = "config";
    private static SharedPreferences sp = XUtil.getApplication().getSharedPreferences("config", 0);

    public SpUtil() {
    }

    public static void setString(String key, String value) {
        sp.edit().putString(key, value).apply();
    }

    public static String getString(String key) {
        return sp.getString(key, "");
    }

    public static void setInt(String key, int value) {
        sp.edit().putInt(key, value).apply();
    }

    public static int getInt(String key) {
        return sp.getInt(key, 0);
    }

    public static void setBoolean(String key, boolean value) {
        sp.edit().putBoolean(key, value).apply();
    }

    public static boolean getBoolean(String key) {
        return sp.getBoolean(key, false);
    }

    public static void setFloat(String key, Float value) {
        sp.edit().putFloat(key, value).apply();
    }

    public static Float getFloat(String key) {
        return sp.getFloat(key, 0.0F);
    }

    public static void setLong(String key, Long value) {
        sp.edit().putLong(key, value).apply();
    }

    public static Long getLong(String key) {
        return sp.getLong(key, 0L);
    }

    public static void removeByKey(String key) {
        sp.edit().remove(key).apply();
    }

    public static void removeAll() {
        sp.edit().clear().apply();
    }
}