package com.example.administrator.routerdemo;

import android.app.Application;

import com.example.commonlib.utils.RouterManager;


/**
 * Created by lishaojie on 2018/1/11.
 */


public class RouterApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initRouter();
    }

    private void initRouter() {

        RouterManager.init(this);
    }


}
