package com.yw.mvpzhihu.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by yw on 17/5/21.
 */
abstract public class RecyclerBeanViewHolder extends RecyclerView.ViewHolder {
    private View mView;
    public RecyclerBeanViewHolder(View itemView) {
        super(itemView);
        this.mView = itemView;
    }

    public View getWidget(int id) {
        return mView.findViewById(id);
    }
}
