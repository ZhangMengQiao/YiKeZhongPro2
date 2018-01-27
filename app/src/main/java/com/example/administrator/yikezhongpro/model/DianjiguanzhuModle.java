package com.example.administrator.yikezhongpro.model;

import com.example.administrator.yikezhongpro.bean.RegistBean;
import com.example.administrator.yikezhongpro.retrofit.BaseObserver;
import com.example.administrator.yikezhongpro.retrofit.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

import retrofit2.http.GET;

/**
 * 趁年轻 创建于 2018/1/27.
 */

public class DianjiguanzhuModle {
    public void getData(String followId, final IDianjiguanzhuModle iDianjiguanzhuModle){
        Map<String, String> map = new HashMap<>();
        map.put("followId",followId );
        map.put("uid","3085");
        map.put("appVersion","101");
        map.put("source","android");
        map.put("token","B492B7D61E9B982BECA64E0FB0F97A9A");
        RetrofitManager.get("quarter/follow",map, new BaseObserver<RegistBean>() {
            @Override
            public void success(RegistBean registBean) {
                if(iDianjiguanzhuModle!=null){
                    iDianjiguanzhuModle.success(registBean);
                }
            }

            @Override
            public void failure(int code) {

            }
        });
    }
    public interface IDianjiguanzhuModle{
        void success(RegistBean registBean);
    }
}
