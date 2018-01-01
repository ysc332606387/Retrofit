package com.example.week1demo2.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.week1demo2.R;
import com.example.week1demo2.app.ImageLoder;
import com.example.week1demo2.bean.Bean;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 墨鸦 on 2017/12/31.
 */

public class Main_adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    //轮播图
    private List<Bean.DataBean.Ad1Bean> ad1;
    //分类框
    private List<Bean.DataBean.Ad5Bean> ad5;
    //热门活动
    private List<Bean.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfo;
    //热门专题
    private List<Bean.DataBean.SubjectsBean> subjects;

    public Main_adapter(Context context, List<Bean.DataBean.Ad1Bean> ad1, List<Bean.DataBean.Ad5Bean> ad5, List<Bean.DataBean.ActivityInfoBean.ActivityInfoListBean> activityInfo, List<Bean.DataBean.SubjectsBean> subjects) {
        this.context = context;
        this.ad1 = ad1;
        this.ad5 = ad5;
        this.activityInfo = activityInfo;
        this.subjects = subjects;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else if (position == 1) {
            return 2;
        } else if (position == 2) {
            return 3;
        } else if (position == 3) {
            return 4;
        } else if (position == 4) {
            return 5;
        } else {
            return 6;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = View.inflate(context, R.layout.layout_banner, null);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        } else if (viewType == 2) {
            View view = View.inflate(context, R.layout.layout_type, null);
            ViewHolder1 holder1 = new ViewHolder1(view);
            return holder1;
        } else if (viewType == 3) {
            View view = View.inflate(context,R.layout.layout_text,null);
            ViewHolder2 holder2 = new ViewHolder2(view);
            return holder2;
        } else if (viewType == 4) {
            View view = View.inflate(context, R.layout.layout_hot1, null);
            ViewHolder3 holder3 = new ViewHolder3(view);
            return holder3;
        } else if (viewType == 5) {
            View view = View.inflate(context,R.layout.layout_text,null);
            ViewHolder4 holder4 = new ViewHolder4(view);
            return holder4;
        } else {
            View view = View.inflate(context, R.layout.layout_hot2, null);
            ViewHolder5 holder5 = new ViewHolder5(view);
            return holder5;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            Banner banner = ((ViewHolder) holder).banner;
            List<String> list = new ArrayList<>();
            for (int i = 0; i < ad1.size(); i++) {
                list.add(ad1.get(i).getImage());
            }
            banner.setImageLoader(new ImageLoder());
            banner.setImages(list);
            banner.start();
        } else if (holder instanceof ViewHolder1) {
            RecyclerView type_recyclerview = ((ViewHolder1) holder).type_recyclerview;
            LinearLayoutManager manager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            type_recyclerview.setLayoutManager(manager);
            type_recyclerview.setAdapter(new Type_adapter(context,ad5));
        } else if (holder instanceof ViewHolder2) {
            TextView titlt = ((ViewHolder2) holder).titlt;
            titlt.setText("热门活动");
        } else if (holder instanceof ViewHolder3) {
            RecyclerView hot1_recyclerview = ((ViewHolder3) holder).hot1_recyclerview;
            LinearLayoutManager manager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            hot1_recyclerview.setLayoutManager(manager);
            hot1_recyclerview.setAdapter(new Hot1_adapter(context,activityInfo));
        } else if (holder instanceof ViewHolder4) {
            TextView titlt = ((ViewHolder4) holder).titlt;
            titlt.setText("热门专题");
        } else if (holder instanceof ViewHolder5) {
            RecyclerView hot2_recyclerview = ((ViewHolder5) holder).hot2_recyclerview;
            GridLayoutManager manager = new GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false);
            hot2_recyclerview.setLayoutManager(manager);
            hot2_recyclerview.setAdapter(new Hot2_adapter(context,subjects));
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final Banner banner;

        public ViewHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {

        private final RecyclerView type_recyclerview;

        public ViewHolder1(View itemView) {
            super(itemView);
            type_recyclerview = itemView.findViewById(R.id.type_recyclerview);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {

        private final TextView titlt;

        public ViewHolder2(View itemView) {
            super(itemView);
            titlt = itemView.findViewById(R.id.titlt);
        }
    }

    class ViewHolder3 extends RecyclerView.ViewHolder {

        private final RecyclerView hot1_recyclerview;

        public ViewHolder3(View itemView) {
            super(itemView);
            hot1_recyclerview = itemView.findViewById(R.id.hot1_recyclerview);
        }
    }

    class ViewHolder4 extends RecyclerView.ViewHolder {

        private final TextView titlt;

        public ViewHolder4(View itemView) {
            super(itemView);
            titlt = itemView.findViewById(R.id.titlt);
        }
    }

    class ViewHolder5 extends RecyclerView.ViewHolder {

        private final RecyclerView hot2_recyclerview;

        public ViewHolder5(View itemView) {
            super(itemView);
            hot2_recyclerview = itemView.findViewById(R.id.hot2_recyclerview);
        }
    }
}
