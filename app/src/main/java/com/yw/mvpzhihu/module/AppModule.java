package com.yw.mvpzhihu.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yw on 17/5/21.
 */

@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }
}

