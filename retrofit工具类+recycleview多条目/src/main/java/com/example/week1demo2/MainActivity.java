package com.example.week1demo2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.week1demo2.adapter.Main_adapter;
import com.example.week1demo2.bean.Bean;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Show_v {

    private RecyclerView main_recycle_view;
    private HashMap<String,String> hashMap = new HashMap<>();
    private String url;
    private Show_p show_p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载视图
        setContentView(R.layout.activity_main);
        initView();
        //调用p层方法
        show_p = new Show_p(this,hashMap,url);
        show_p.get();

    }

    private void initView() {
        main_recycle_view = (RecyclerView) findViewById(R.id.main_recycle_view);
        hashMap.put("uri","homepage");
        url = "http://result.eolinker.com/";
    }

    @Override
    public void showSuccess(Bean bean) {
        Bean bean1 = (Bean) bean;
        //轮播图
        List<Bean.DataBean.Ad1Bean> ad1 = bean1.getData().getAd1();
        //分类框
        List<Bean.DataBean.Ad5Bean> ad5 = bean1.getData().getAd5();
        //热门活动
        List<Bean.DataBean.ActivityInfoBean.ActivityInfoListBean> info = bean1.getData().getActivityInfo().getActivityInfoList();
        //热门专题
        List<Bean.DataBean.SubjectsBean> subjects = bean1.getData().getSubjects();
        //布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
        //添加布局管理器
        main_recycle_view.setLayoutManager(manager);
        //添加适配器
        main_recycle_view.setAdapter(new Main_adapter(MainActivity.this,ad1,ad5,info,subjects));
    }

    @Override
    public void showFailed() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(show_p!=null){
            show_p.onBind();
        }
    }
}
