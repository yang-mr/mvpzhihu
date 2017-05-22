package com.yw.mvpzhihu.ui.presenter;

import com.yw.mvpzhihu.contact.base.BaseContact;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by yw on 17/5/21.
 */
public class BasePresenter<T extends BaseContact.BaseView> implements BaseContact.BasePresenter<T> {
    public T mView;
    private CompositeSubscription compositeSubscription;

    protected void addSubscription(Subscription subscription) {
        if (null == compositeSubscription) {
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(subscription);
    }

    protected void unSubscription() {
        if (null != compositeSubscription) {
            compositeSubscription.unsubscribe();
        }
    }
    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscription();
    }
}
