package com.example.loginlibrary.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.commonlib.utils.ActionConstant;
import com.example.commonlib.utils.Router;
import com.example.commonlib.utils.RouterManagerByMap;
import com.example.loginlibrary.R;

/**
 * Created by lishaojie on 2018/1/11.
 */

public class LoginActivity extends Activity {
    private EditText mEtUserName, mEtPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_login);
        initView();
    }

    private void initView() {
        mEtUserName = findViewById(R.id.et_userName);
        mEtPwd = findViewById(R.id.et_passWord);
    }

    public void login(View view) {
        jumpByRouterByMap();
    }

    /**
     * 通过action实现的路由
     */
    private void jumpByAction() {
        Intent intent = new Intent();
        intent.setAction(ActionConstant.ACTION_USER_INFO);
        intent.putExtra(ActionConstant.KEY_USER_NAME, mEtUserName.getText().toString());
        intent.putExtra(ActionConstant.KEY_PASS_WORD, mEtPwd.getText().toString());
        if (ActionConstant.isIntentAvailable(this, intent)) {
            startActivity(intent);
        }
    }
    /**
     * 通过Schema实现的路由
     */
    private void jumpByScheme() {
        Intent intent = new Intent();
        intent.setAction(ActionConstant.ACTION_USER_INFO);
        intent.putExtra(ActionConstant.KEY_USER_NAME, mEtUserName.getText().toString());
        intent.putExtra(ActionConstant.KEY_PASS_WORD, mEtPwd.getText().toString());
        intent.setData(Uri.parse("http://www.baidu.com:80/login"));
        intent.getCategories();
        if (ActionConstant.isIntentAvailable(this, intent)) {
            startActivity(intent);
        }
    }
    /**
     * 通过初始化跳转表实现路由
     */
    private void jumpByRouterByMap() {
        new Router.Builder(this, RouterManagerByMap.getInstance().getRouter(ActionConstant.ACTION_USER_INFO))
                .addParams(ActionConstant.KEY_USER_NAME, mEtUserName.getText().toString())
                .addParams(ActionConstant.KEY_PASS_WORD, mEtPwd.getText().toString()).build().jump();
    }
    /**
     * 通过注解实现的路由
     */
    private void jumpByRouterByAnnotation() {
        new Router.Builder(this, RouterManagerByMap.getInstance().getRouter(ActionConstant.ACTION_USER_INFO))
                .addParams(ActionConstant.KEY_USER_NAME, mEtUserName.getText().toString())
                .addParams(ActionConstant.KEY_PASS_WORD, mEtPwd.getText().toString()).build().jump();
    }


}
