package com.example.administrator.yikezhongpro.view;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 趁年轻 创建于 2018/1/22.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
