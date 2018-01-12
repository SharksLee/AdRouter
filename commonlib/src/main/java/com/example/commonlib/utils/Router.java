package com.example.commonlib.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by lishaojie on 2018/1/11.
 */

public class Router {
    private Context mContext;
    private Class mClass;
    private ArrayMap<String, Serializable> mArrayMap;

    public Router(Context context, Class aClass, ArrayMap<String, Serializable> arrayMap) {
        mContext = context;
        mClass = aClass;
        mArrayMap = arrayMap;
    }

    public void jump() {
        if (mClass == null) {
            Toast.makeText(mContext, "未找到对应的跳转路径", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(mContext, mClass);
        if (mArrayMap != null && !mArrayMap.isEmpty()) {
            Set<String> keys = mArrayMap.keySet();
            for (String key : keys) {
                intent.putExtra(key, mArrayMap.get(key));
            }
        }
        if (ActionConstant.isIntentAvailable(mContext, intent)) {
            mContext.startActivity(intent);
        }

    }

    public static class Builder {
        private Context mContext;
        private Class<Activity> mClass;
        private ArrayMap<String, Serializable> mArrayMap;

        public Builder(Context context, Class aClass) {
            mContext = context;
            mClass = aClass;
        }

        public Builder addParams(String key, Serializable value) {
            if (mArrayMap == null) {
                mArrayMap = new ArrayMap<>();
            }
            mArrayMap.put(key, value);
            return this;
        }

        public Router build() {
            return new Router(mContext, mClass, mArrayMap);
        }


    }
}
