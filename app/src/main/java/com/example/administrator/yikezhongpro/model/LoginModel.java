package com.example.administrator.yikezhongpro.model;

import com.example.administrator.yikezhongpro.bean.LoginBean;
import com.example.administrator.yikezhongpro.retrofit.BaseObserver;
import com.example.administrator.yikezhongpro.retrofit.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

/**
 * 趁年轻 创建于 2018/1/25.
 */

public class LoginModel {
    public void getData(String name, String pwd, final ILoginModel iLoginModel) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", name);
        map.put("password", pwd);
        map.put("appVersion","101");
        map.put("source","android");
        RetrofitManager.get("user/login", map, new BaseObserver<LoginBean>() {
            @Override
            public void success(LoginBean loginBean) {
                if (iLoginModel != null) {
                    iLoginModel.success(loginBean);
                }
            }

            @Override
            public void failure(int code) {

            }
        });
    }
        public interface ILoginModel {
        void success(LoginBean loginBean);
    }
}
