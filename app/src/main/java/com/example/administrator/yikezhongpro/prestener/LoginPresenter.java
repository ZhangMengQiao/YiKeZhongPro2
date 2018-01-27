package com.example.administrator.yikezhongpro.prestener;

import android.text.TextUtils;

import com.example.administrator.yikezhongpro.bean.LoginBean;
import com.example.administrator.yikezhongpro.model.LoginModel;

/**
 * 趁年轻 创建于 2018/1/25.
 */

public class LoginPresenter {
    ILoginView iLoginView;
    LoginModel loginModel;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        loginModel = new LoginModel();
    }

    public void getData(String name, String pwd) {
        //判断用户名为空
        if (TextUtils.isEmpty(name)) {
            if (iLoginView != null) {
                iLoginView.getname("用户名不能为空");
                return;
            }
        }
        //判断密码是否为空
        if (TextUtils.isEmpty(pwd)) {
            if (iLoginView != null) {
                iLoginView.getpwd("密码不能为空");
            }
        }
        //调用M层数据
        loginModel.getData(name, pwd, new LoginModel.ILoginModel() {
            @Override
            public void success(LoginBean loginBean) {
                if (iLoginView != null) {
                    iLoginView.success(loginBean.getMsg());
                }
            }
        });
    }

    //内存泄漏
    public void detach() {
        iLoginView = null;
    }

    public interface ILoginView {
        void success(String s);

        void failed(String s);

        void getname(String s);

        void getpwd(String s);
    }
}
