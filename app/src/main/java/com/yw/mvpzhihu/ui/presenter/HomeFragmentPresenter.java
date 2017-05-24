package com.yw.mvpzhihu.ui.presenter;

import com.socks.library.KLog;
import com.yw.mvpzhihu.api.ZhihuApi;
import com.yw.mvpzhihu.bean.HomeBean;
import com.yw.mvpzhihu.contact.HomeFragmentContact;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yw on 17/5/21.
 */
public class HomeFragmentPresenter extends BasePresenter<HomeFragmentContact.View> implements HomeFragmentContact.Presenter<HomeFragmentContact.View>{
    private ZhihuApi mZhihuApi;

    @Inject
    public HomeFragmentPresenter(ZhihuApi mZhihuApi) {
        this.mZhihuApi = mZhihuApi;
    }

    @Override
    public void getHomeList() {
        KLog.d();
        Subscription subscription = mZhihuApi.getHomeList()
//                .map(new Func1<HomeBean, HomeBean>() {
//                    @Override
//                    public HomeBean call(HomeBean homeBean) {
//                        KLog.d(homeBean.getStories().size());
//                        KLog.d(homeBean.getStories().get(0).getTitle());
//                        return null;
//                    }
//                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<HomeBean>() {
                    @Override
                    public void onCompleted() {
                        KLog.d();
                        mView.refreshEnd();
                    }

                    @Override
                    public void onError(Throwable e) {
                        KLog.d(e.getStackTrace());
                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        KLog.d(homeBean.getStories().size());

                        mView.showHomeList(homeBean);
                    }
                });
        addSubscription(subscription);
    }
}
