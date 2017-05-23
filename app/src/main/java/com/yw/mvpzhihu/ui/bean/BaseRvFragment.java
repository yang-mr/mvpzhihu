package com.yw.mvpzhihu.ui.bean;

import com.yw.mvpzhihu.component.AppComponent;
import com.yw.mvpzhihu.contact.base.BaseContact;

import javax.inject.Inject;

/**
 * Created by yangwei on 2017/5/23--16:05.
 * <p>
 * E-Mail:yangwei199402@gmail.com
 */

public class BaseRvFragment<T extends BaseContact.BasePresenter> extends BaseFragment {

    @Inject
    protected T mPresenter;
    @Override
    public int setContentId() {
        return 0;
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void setInject(AppComponent appComponent) {

    }
}
