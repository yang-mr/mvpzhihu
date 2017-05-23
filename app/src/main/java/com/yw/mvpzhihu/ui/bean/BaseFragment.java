package com.yw.mvpzhihu.ui.bean;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.socks.library.KLog;
import com.yw.mvpzhihu.AppApplication;
import com.yw.mvpzhihu.component.AppComponent;
import com.yw.mvpzhihu.contact.base.BaseContact;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by yw on 17/5/20.
 */
public abstract class BaseFragment extends Fragment {
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

        KLog.d();
        initDatas();
        setInject(AppApplication.getInstance().getAppComponent());
    }

    public abstract int setContentId();

    public abstract void initDatas();

    public abstract void setInject(AppComponent appComponent);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}

