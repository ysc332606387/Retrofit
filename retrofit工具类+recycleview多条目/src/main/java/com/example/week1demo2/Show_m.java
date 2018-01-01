package com.example.week1demo2;

import com.example.week1demo2.bean.Bean;
import com.example.week1demo2.utils.CallBack;
import com.example.week1demo2.utils.RetrofitUtils;

import java.util.Map;

/**
 * Created by 墨鸦 on 2017/12/31.
 */

public class Show_m {
    public void getData(String url, Map<String, String> map, final Show_p show_p){
        RetrofitUtils.getInstance().getNews(url, new CallBack() {
            @Override
            public void onSuccess(Object o) {
                Bean bean = (Bean) o;
                show_p.showSuccess(bean);
            }

            @Override
            public void onFailed(Throwable t) {
                show_p.showFailed();
            }
        },map);
    }
}
