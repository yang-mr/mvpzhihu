package com.yw.mvpzhihu.ui.adapter;

import android.content.Context;
import android.view.View;

/**
 * Created by yw on 17/5/21.
 */
public class HomeViewHolder extends RecyclerBeanViewHolder {
    private View mView;
    private Context mContext;
    public HomeViewHolder(Context context, View view) {
        super(view);
        this.mContext = context;
        this.mView = itemView;
    }

    public View getWidget(int id) {
        return mView.findViewById(id);
    }
}
