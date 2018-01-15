package com.example.administrator.routerdemo;

import android.app.Application;

import com.example.commonlib.utils.ActionConstant;
import com.example.commonlib.utils.RouterByAnnotationManager;
import com.example.commonlib.utils.RouterManagerByMap;
import com.example.userinfolibrary.activity.UserInfoActivity;


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
        RouterByAnnotationManager.getInstance().init(this);
        RouterManagerByMap.getInstance().addRouter(ActionConstant.ACTION_USER_INFO, UserInfoActivity.class);
    }


}
