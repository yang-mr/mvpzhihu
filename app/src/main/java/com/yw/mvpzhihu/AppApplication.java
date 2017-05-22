package com.yw.mvpzhihu;

import android.app.Application;
import android.content.Context;

import com.socks.library.KLog;

/**
 * Created by yw on 17/5/20.
 */
public class AppApplication extends Application {
    private static AppApplication mContext;

    public static Context getInstance() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        KLog.init(true, "yw");
    }
}
