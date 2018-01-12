package com.example.userinfolibrary.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.commonlib.utils.ActionConstant;
import com.example.commonlib.utils.RouterTarget;
import com.example.userinfolibrary.R;


/**
 * Created by lishaojie on 2018/1/11.
 */
@RouterTarget(ActionConstant.ACTION_USER_INFO)
public class UserInfoActivity extends Activity {
    private TextView mTvName, mTvPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ac_user_info);
        mTvName = findViewById(R.id.tv_name);
        mTvPwd = findViewById(R.id.tv_pwd);
        mTvName.setText("用户名：" + getIntent().getStringExtra(ActionConstant.KEY_USER_NAME));
        mTvPwd.setText("密码：" + getIntent().getStringExtra(ActionConstant.KEY_PASS_WORD));


    }
}
