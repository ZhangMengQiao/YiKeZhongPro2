package com.example.administrator.yikezhongpro.model;

import com.example.administrator.yikezhongpro.bean.MyguanzhuBean;
import com.example.administrator.yikezhongpro.retrofit.BaseObserver;
import com.example.administrator.yikezhongpro.retrofit.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

/**
 * 趁年轻 创建于 2018/1/26.
 */

public class MyguanzhuModel {
    public void getData(final IMyguanzhuModel iMyguanzhuModel){
        Map<String,String> map=new HashMap<>();
        map.put("source","android");
        map.put("token","B492B7D61E9B982BECA64E0FB0F97A9A");
        map.put("appVersion","101");
        map.put("uid","3085");
        RetrofitManager.get("quarter/getFollowUsers",map, new BaseObserver<MyguanzhuBean>() {
            @Override
            public void success(MyguanzhuBean myguanzhuBean) {
                if(iMyguanzhuModel!=null){
                    iMyguanzhuModel.success(myguanzhuBean);
                }
            }

            @Override
            public void failure(int code) {

            }
        });
    }
    public interface IMyguanzhuModel{
        void success(MyguanzhuBean myguanzhuBean);
    }
}
