package com.yw.mvpzhihu.ui.bean;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.socks.library.KLog;
import com.yw.mvpzhihu.contact.base.BaseContact;

import butterknife.ButterKnife;

/**
 * Created by yw on 17/5/20.
 */
public abstract class BeanFragment<T extends BaseContact.BasePresenter> extends Fragment implements BaseContact.BaseView{
    public T mPresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        KLog.d();
        View view = inflater.inflate(setContentId(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mPresenter.attachView(this);
        KLog.d();
        initDatas();
    }

    public abstract int setContentId();

    public abstract void initDatas();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
        mPresenter.detachView();
    }
}

