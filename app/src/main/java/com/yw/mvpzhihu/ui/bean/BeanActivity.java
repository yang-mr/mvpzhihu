package com.yw.mvpzhihu.ui.bean;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.socks.library.KLog;

import butterknife.ButterKnife;

/**
 * Created by yw on 17/5/20.
 */
public abstract class BeanActivity extends FragmentActivity {
    protected Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        KLog.d(setLayoutId());
        mContext = this;

        ButterKnife.bind(this);
        initData();
    }

    public abstract int setLayoutId();

    public abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}