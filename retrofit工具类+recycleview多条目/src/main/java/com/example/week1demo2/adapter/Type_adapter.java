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
 * Created by 墨鸦 on 2017/12/31.
 */

public class Type_adapter extends RecyclerView.Adapter<Type_adapter.ViewHolder>{

    private Context context;
    private List<Bean.DataBean.Ad5Bean> ad5;

    public Type_adapter(Context context, List<Bean.DataBean.Ad5Bean> ad5) {
        this.context = context;
        this.ad5 = ad5;
    }

    @Override
    public Type_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.layout_type_show, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Type_adapter.ViewHolder holder, int position) {
        holder.type_img.setImageURI(ad5.get(position).getImage());
        holder.type_title.setText(ad5.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return ad5.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView type_img;
        private final TextView type_title;

        public ViewHolder(View itemView) {
            super(itemView);
            type_img = (SimpleDraweeView) itemView.findViewById(R.id.type_img);
            type_title = (TextView) itemView.findViewById(R.id.type_title);
        }
    }
}
