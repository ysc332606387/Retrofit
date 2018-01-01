package com.example.week1demo2.utils;

import com.example.week1demo2.bean.Bean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:Created by Constraint.
 */

public class RetrofitUtils {
    private static volatile RetrofitUtils instance;
    public static RetrofitUtils getInstance(){
        if (instance==null){
            synchronized (RetrofitUtils.class){
                if (instance==null){
                    instance=new RetrofitUtils();
                }
            }
        }
        return instance;
    }
    public void getNews(String baseurl, final CallBack callBack, Map map){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<Bean> call = apiService.getGoods(map);
        call.enqueue(new Callback<Bean>() {
            @Override
            public void onResponse(Call<Bean> call, Response<Bean> response) {
                Bean body = response.body();
                callBack.onSuccess(body);
            }

            @Override
            public void onFailure(Call<Bean> call, Throwable t) {
                callBack.onFailed(t);
            }
        });
    }
}
