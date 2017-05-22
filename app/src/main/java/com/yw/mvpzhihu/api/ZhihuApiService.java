package com.yw.mvpzhihu.api;

import com.yw.mvpzhihu.bean.HomeBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by yw on 17/5/20.
 */
public interface ZhihuApiService {

    @GET("api/4/news/latest")
    Observable<HomeBean> getHomeLists();
}
