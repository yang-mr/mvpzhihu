package com.yw.mvpzhihu.ui.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.socks.library.KLog;
import com.yw.mvpzhihu.R;
import com.yw.mvpzhihu.api.ZhihuApi;
import com.yw.mvpzhihu.bean.HomeBean;
import com.yw.mvpzhihu.component.AppComponent;
import com.yw.mvpzhihu.component.DaggerHomeComponent;
import com.yw.mvpzhihu.contact.HomeFragmentContact;
import com.yw.mvpzhihu.ui.adapter.HomeFragmentAdapter;
import com.yw.mvpzhihu.ui.base.BaseRvFragment;
import com.yw.mvpzhihu.ui.presenter.HomeFragmentPresenter;

import butterknife.Bind;

/**
 * Created by yw on 17/5/20.
 */
public class HomeFragment extends BaseRvFragment<HomeFragmentPresenter> implements HomeFragmentContact.View, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.swiperefreshlayout)
    SwipeRefreshLayout swiperefreshlayout;
    @Bind(R.id.recyc_view)
    RecyclerView recycView;

    private HomeBean beans;
    private HomeFragmentAdapter mAdapter;

    @Override
    protected void attachView() {
        mPresenter.attachView(this);
    }

    @Override
    public int setContentId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initDatas() {
        mPresenter.attachView(this);
        ZhihuApi zhihuApi = ZhihuApi.getInstance();
        KLog.d(zhihuApi);

        recycView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycView.setItemAnimator(new DefaultItemAnimator());

        swiperefreshlayout.setOnRefreshListener(this);
        onRefresh();
    }

    @Override
    public void setInject(AppComponent appComponent) {
        KLog.d(appComponent);
        DaggerHomeComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void onRefresh() {
        recycView.setAdapter(mAdapter = new HomeFragmentAdapter(getActivity()));
        mPresenter.getHomeList();
    }

    @Override
    public void showHomeList(HomeBean bean) {
        mAdapter.clear();
        mAdapter.add(bean.getStories());
        KLog.d();
    }

    @Override
    public void refreshEnd() {
        KLog.d();
        if (swiperefreshlayout.isRefreshing()) {
            swiperefreshlayout.setRefreshing(false);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
