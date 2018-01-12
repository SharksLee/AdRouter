package com.example.commonlib.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

/**
 * 隐式调用Activity的Action
 * Created by lishaojie on 2018/1/10.
 */

public class ActionConstant {
    public static final String ACTION_USER_INFO = "android.intent.action.USERINFO";
    public static final String KEY_USER_NAME = "KEY_USER_NAME";
    public static final String KEY_PASS_WORD = "KEY_PASS_WORD";

    /**
     * 判断Intent是否合法可以跳转成功
     * @param context
     * @param intent
     * @return
     */
    public static boolean isIntentAvailable(Context context, Intent intent) {
        return !context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY).isEmpty();
    }

}
