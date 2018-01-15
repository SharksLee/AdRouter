package com.example.commonlib.utils;

import android.support.v4.util.ArrayMap;

/**
 * Created by lishaojie on 2018/1/15.
 */

public class RouterManagerByMap {
    private static RouterManagerByMap instance = new RouterManagerByMap();
    private ArrayMap<String, Class> routers = new ArrayMap<>();

    private RouterManagerByMap() {
    }

    public static RouterManagerByMap getInstance() {
        return instance;
    }

    public void addRouter(String key, Class activity) {
        routers.put(key, activity);
    }

    public Class getRouter(String key) {
        return routers.get(key);
    }
}
