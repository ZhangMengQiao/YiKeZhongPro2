package com.example.administrator.yikezhongpro.model;

import com.example.administrator.yikezhongpro.bean.RegistBean;
import com.example.administrator.yikezhongpro.retrofit.BaseObserver;
import com.example.administrator.yikezhongpro.retrofit.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

/**
 * 趁年轻 创建于 2018/1/25.
 */

public class RegistModel {
    public void getData(String name, String pwd, final IRgistModel iRgistModel) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", name);
        map.put("password", pwd);
        map.put("appVersion","101");
        map.put("source","android");
        RetrofitManager.get("user/reg", map, new BaseObserver<RegistBean>() {
            @Override
            public void success(RegistBean registerBean) {
                if (iRgistModel != null) {
                    iRgistModel.success(registerBean);
                }
            }

            @Override
            public void failure(int code) {

            }
        });
    }

    public interface IRgistModel {
        void success(RegistBean registerBean);
    }

}
