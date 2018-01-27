package com.example.administrator.yikezhongpro.model;

import com.example.administrator.yikezhongpro.bean.RegistBean;
import com.example.administrator.yikezhongpro.retrofit.BaseObserver;
import com.example.administrator.yikezhongpro.retrofit.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

/**
 * 趁年轻 创建于 2018/1/26.
 */

public class FabuDuanziModel {
    public void getData(String content , final IFabuDuanModel iFabuDuanModel){
        Map<String, String> map = new HashMap<>();
        map.put("content",content );
        map.put("uid","3085");
        map.put("appVersion","101");
        map.put("source","android");
        map.put("token","B492B7D61E9B982BECA64E0FB0F97A9A");

        RetrofitManager.get("quarter/publishJoke",map, new BaseObserver<RegistBean>() {
            @Override
            public void success(RegistBean registBean) {
                if(iFabuDuanModel!=null){
                    iFabuDuanModel.success(registBean);
                }
            }

            @Override
            public void failure(int code) {

            }
        });
    }
    public interface IFabuDuanModel {
        void success(RegistBean registBean);
    }
}
