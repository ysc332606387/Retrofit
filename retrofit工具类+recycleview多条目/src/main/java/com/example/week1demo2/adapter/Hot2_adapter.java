package com.example.week1demo2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.week1demo2.R;
import com.example.week1demo2.bean.Bean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 墨鸦 on 2018/1/1.
 */

public class Hot2_adapter extends RecyclerView.Adapter<Hot2_adapter.ViewHolder> {

    private Context context;
    List<Bean.DataBean.SubjectsBean> subjects;

    public Hot2_adapter(Context context, List<Bean.DataBean.SubjectsBean> subjects) {
        this.context = context;
        this.subjects = subjects;
    }

    @Override
    public Hot2_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.layout_hot2_show,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Hot2_adapter.ViewHolder holder, int position) {
        holder.hot2_fresco.setImageURI(subjects.get(0).getGoodsList().get(position).getGoodsImage());
        holder.hot2_title.setText(subjects.get(0).getGoodsList().get(position).getGoods_name());
    }

    @Override
    public int getItemCount() {
        return subjects.get(0).getGoodsList().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView hot2_fresco;
        private final TextView hot2_title;

        public ViewHolder(View itemView) {
            super(itemView);
            hot2_fresco = itemView.findViewById(R.id.hot2_fresco);
            hot2_title = itemView.findViewById(R.id.hot2_title);
        }
    }
}
