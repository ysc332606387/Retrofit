package com.example.week1demo2.app;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by 墨鸦 on 2017/12/31.
 */

public class ImageLoder extends ImageLoader {
    //此方法用于为Viewpager上展示ImagerView（图片）的控件设置图片
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //通过glide设置图片
        Glide.with(context).load(path).into(imageView);
    }
}