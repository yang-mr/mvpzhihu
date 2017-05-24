package com.yw.mvpzhihu.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yw.mvpzhihu.R;
import com.yw.mvpzhihu.bean.HomeBean;

import java.util.List;

/**
 * Created by yw on 17/5/21.
 */
public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeViewHolder> {
    private List<HomeBean.Story> list;
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_fragment_item, null);
        return new HomeViewHolder(mContext, view);
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        ImageView iv_title = (ImageView) holder.getWidget(R.id.iv_title);
        TextView tv_title = (TextView) holder.getWidget(R.id.tv_title);

        HomeBean.Story story = list.get(position);
        tv_title.setText(story.getTitle());

        if (story.getImages() != null)
        Picasso.with(mContext)
                .load(story.getImages()[0])
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .fit()
                .tag(this)
                .into(iv_title);
    }

    public void add(List list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void clear() {
        this.list = null;
    }

    @Override
    public int getItemCount() {
        if (null == list) {
            return 0;
        }
        return list.size();
    }
}
