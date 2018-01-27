package com.example.administrator.yikezhongpro.model;

import com.example.administrator.yikezhongpro.bean.Lunbo;
import com.example.administrator.yikezhongpro.retrofit.BaseObserver;
import com.example.administrator.yikezhongpro.retrofit.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

/**
 * 趁年轻 创建于 2018/1/24.
 */

public class LunboModel {

    public void getData(final ILunboModel iLunboModel) {
        Map<String, String> map = new HashMap<>();
        map.put("source", "android");
        RetrofitManager.get("quarter/getAd", map, new BaseObserver<Lunbo>() {
            @Override
            public void success(Lunbo lunbo) {
                if(iLunboModel!=null){
                    iLunboModel.success(lunbo);
                }
            }

            @Override
            public void failure(int code) {

            }
        });

    }

    public interface ILunboModel {
        void success(Lunbo lunbo);
    }

}
