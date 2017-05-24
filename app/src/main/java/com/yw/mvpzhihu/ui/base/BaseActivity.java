package com.yw.mvpzhihu.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.socks.library.KLog;
import com.yw.mvpzhihu.R;

import butterknife.ButterKnife;

/**
 * Created by yw on 17/5/20.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    private Toolbar mToolbar;
    private TextView mTitle_Tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        KLog.d(setLayoutId());
        mContext = this;

        ButterKnife.bind(this);
        mToolbar = ButterKnife.findById(this, R.id.common_toolbar);

        if (null != mToolbar) {
            mTitle_Tv = ButterKnife.findById(this, R.id.tv_title);
            initToolbar();
            setSupportActionBar(mToolbar);
            setTitle("");
            mTitle_Tv.setText("你猜啊");
        }
        initData();
    }

    public abstract int setLayoutId();

    public abstract void initData();

    protected abstract void initToolbar();
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}