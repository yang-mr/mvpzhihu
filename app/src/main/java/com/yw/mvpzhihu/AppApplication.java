package com.yw.mvpzhihu;

import android.app.Application;

import com.socks.library.KLog;
import com.yw.mvpzhihu.component.AppComponent;
/*import com.yw.mvpzhihu.component.DaggerAppComponent;*/
import com.yw.mvpzhihu.component.DaggerAppComponent;
import com.yw.mvpzhihu.module.ApiModule;
import com.yw.mvpzhihu.module.AppModule;

/**
 * Created by yw on 17/5/20.
 */
public class AppApplication extends Application {
    private static AppApplication mContext;
    private static AppComponent mAppComponent;

    public static AppApplication getInstance() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = AppApplication.this;

        initAppComponent();
        KLog.init(true, "yw");
    }

    private void initAppComponent() {
        mAppComponent = DaggerAppComponent.builder()
                .apiModule(new ApiModule())
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return mAppComponent;
    }
}
