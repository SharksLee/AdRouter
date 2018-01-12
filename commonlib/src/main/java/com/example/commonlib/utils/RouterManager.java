package com.example.commonlib.utils;

import android.app.Application;
import android.support.v4.util.ArrayMap;
import android.util.Log;

import java.util.Enumeration;

import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;


/**
 * Created by lishaojie on 2018/1/11.
 */

public class RouterManager {
    private static RouterManager instance = new RouterManager();
    private ArrayMap<String, Class> routers = new ArrayMap<>();

    private RouterManager() {
    }

    public static RouterManager getInstance() {
        return instance;
    }

    private void addRouter(String key, Class activity) {
        routers.put(key, activity);
    }

    public Class getRouter(String key) {
        return routers.get(key);
    }
    public static void init(Application application) {
        try {
            //通过资源路径获得DexFile,注意5.0以上版本要求关掉instant run 方法否则会自动拆包遍历不到所有的类
            DexFile e = new DexFile(application.getPackageCodePath());
            Enumeration entries = e.entries();
            //遍历所有元素
            while (entries.hasMoreElements()) {
                String entryName = (String) entries.nextElement();
                Log.e("entryName", entryName);
                //匹配Activity包名
                if (entryName.contains("activity")) {
                    //通过反射获得Activity类
                    Class entryClass = Class.forName(entryName);
                    if (entryClass.isAnnotationPresent(RouterTarget.class)) {
                        RouterTarget action = (RouterTarget) entryClass.getAnnotation(RouterTarget.class);
                        RouterManager.getInstance().addRouter(action.value(), entryClass);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
