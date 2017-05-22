package com.yw.mvpzhihu.component;

import android.content.Context;

import com.yw.mvpzhihu.api.ZhihuApi;
import com.yw.mvpzhihu.module.ApiModule;
import com.yw.mvpzhihu.module.AppModule;

import dagger.Component;

/**
 * Created by yw on 17/5/21.
 */

@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
    Context getContext();
    ZhihuApi getZhihuApi();
}
