package com.example.week1demo2;

import com.example.week1demo2.bean.Bean;

import java.util.HashMap;

/**
 * Created by 墨鸦 on 2017/12/31.
 */

public class Show_p implements Show_p_interface {

    private Show_v show_v;
    private HashMap<String,String> hashMap = new HashMap<>();
    private String uri;
    private Show_m show_m;

    public Show_p(Show_v show_v, HashMap<String, String> hashMap, String uri) {
        this.show_v = show_v;
        this.hashMap = hashMap;
        this.uri = uri;
        show_m = new Show_m();
    }

    public void get(){
        show_m.getData(uri,hashMap,this);
    }

    @Override
    public void showSuccess(Bean bean) {
        show_v.showSuccess(bean);
    }

    @Override
    public void showFailed() {
        show_v.showFailed();
    }
    public void onBind(){
        if(show_v!=null){
            show_v = null;
        }
    }
}
