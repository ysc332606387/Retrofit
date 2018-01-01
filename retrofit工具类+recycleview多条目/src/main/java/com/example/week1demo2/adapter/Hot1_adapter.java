package com.example.week1demo2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.week1demo2.R;
import com.example.week1demo2.bean.Bean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 墨鸦 on 2018/1/1.
 */

public class Hot1_adapter extends RecyclerView.Adapter<Hot1_adapter.ViewHolder> {

    private Context context;
    private List<Bean.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfo;

    public Hot1_adapter(Context context, List<Bean.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfo) {
        this.context = context;
        this.activityInfo = activityInfo;
    }

    @Override
    public Hot1_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.layout_hot1_show, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Hot1_adapter.ViewHolder holder, int position) {
        holder.hot1_fresco.setImageURI(activityInfo.get(position).getActivityImg());
    }

    @Override
    public int getItemCount() {
        return activityInfo.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView hot1_fresco;

        public ViewHolder(View itemView) {
            super(itemView);
            hot1_fresco = itemView.findViewById(R.id.hot1_fresco);
        }
    }
}
