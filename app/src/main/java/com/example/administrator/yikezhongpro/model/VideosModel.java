package com.example.administrator.yikezhongpro.model;

import com.example.administrator.yikezhongpro.bean.VideosBean;
import com.example.administrator.yikezhongpro.retrofit.BaseObserver;
import com.example.administrator.yikezhongpro.retrofit.RetrofitManager;

import java.util.HashMap;
import java.util.Map;
/**
 * 趁年轻 创建于 2018/1/25.
 */

public class VideosModel {
    public void getData(final IVideosModel iVideosModel){
        Map<String, String> map = new HashMap<>();
        map.put("source", "android");
        map.put("page","1");
        map.put("appVersion","101");
        map.put("token","B492B7D61E9B982BECA64E0FB0F97A9A");
        RetrofitManager.get("quarter/getVideos",map, new BaseObserver<VideosBean>() {
            @Override
            public void success(VideosBean videosBean) {
                if(iVideosModel!=null){
                    iVideosModel.scuccess(videosBean);
                }
            }

            @Override
            public void failure(int code) {

            }
        });
    }
    public interface  IVideosModel{
        void scuccess(VideosBean videosBean);
    }
}
