package com.yw.mvpzhihu.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yw.mvpzhihu.R;

import java.util.List;

/**
 * Created by yw on 17/5/21.
 */
public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeViewHolder> {
    private List list;
    private Context mContext;
    public HomeFragmentAdapter(Context context) {
        this.mContext = context;
    }
    public HomeFragmentAdapter(List list, Context context) {
        this.list = list;
        this.mContext = context;
    }
    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.activity_main, null);
        return new HomeViewHolder(mContext, view);
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {

    }

    public void add(List list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (null == list) {
            return 0;
        }
        return list.size();
    }
}
