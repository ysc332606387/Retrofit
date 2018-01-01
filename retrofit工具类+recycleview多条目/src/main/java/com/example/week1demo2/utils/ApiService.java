package com.example.week1demo2.utils;

        import com.example.week1demo2.bean.Bean;

        import java.util.Map;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.QueryMap;

/**
 * author:Created by Constraint.
 */

public interface ApiService {
    //http://result.eolinker.com/umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage
    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611")
    Call<Bean> getGoods(@QueryMap Map<String, String> map);
}
