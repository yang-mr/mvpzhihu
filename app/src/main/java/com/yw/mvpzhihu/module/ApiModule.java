package com.yw.mvpzhihu.module;

import com.yw.mvpzhihu.api.ZhihuApi;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yw on 17/5/21.
 */
@Module
public class ApiModule {
    @Provides
    ZhihuApi provideZhihuApiService() {
        return ZhihuApi.getInstance();
    }
}
