package com.yw.mvpzhihu.contact.base;

/**
 * Created by yw on 17/5/21.
 */
public interface BaseContact {
    interface BasePresenter<T extends BaseContact.BaseView>{
        void attachView(T view);
        void detachView();
    }

    interface BaseView{

    }
}
