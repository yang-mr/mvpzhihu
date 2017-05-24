package com.yw.mvpzhihu.contact;

import com.yw.mvpzhihu.bean.HomeBean;
import com.yw.mvpzhihu.contact.base.BaseContact;

/**
 * Created by yw on 17/5/21.
 */
public interface HomeFragmentContact {
    interface View extends BaseContact.BaseView {
        void showHomeList(HomeBean b);
        void refreshEnd();
    }

    interface Presenter<T extends BaseContact.BaseView> extends BaseContact.BasePresenter<T> {
        void getHomeList();
    }
}
