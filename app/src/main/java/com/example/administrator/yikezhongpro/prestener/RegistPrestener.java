package com.example.administrator.yikezhongpro.prestener;

import android.text.TextUtils;

import com.example.administrator.yikezhongpro.bean.RegistBean;
import com.example.administrator.yikezhongpro.model.RegistModel;

/**
 * 趁年轻 创建于 2018/1/25.
 */

public class RegistPrestener {
    IRegistView iRegistView;
    RegistModel registModel;

    public RegistPrestener(IRegistView iRegistView) {
        this.iRegistView = iRegistView;
        registModel = new RegistModel();
    }

    public void getData(String name, String pwd) {
        //判断用户名不能为空
        if (TextUtils.isEmpty(name)) {
            if (iRegistView != null) {
                iRegistView.getname("用户名不能为空");
                return;
            }
        }
        //判断密码不能为空
        if (TextUtils.isEmpty(pwd)) {
            if (iRegistView != null) {
                iRegistView.getpwd("密码不能为空");
                return;
            }
        }
        //调用m层数据
        registModel.getData(name, pwd, new RegistModel.IRgistModel() {
            @Override
            public void success(RegistBean registerBean) {
                if (iRegistView != null) {
                    iRegistView.success(registerBean.getMsg());
                }
            }
        });
    }

    //防止内存泄漏
    public void detach() {
        iRegistView = null;
    }

    public interface IRegistView {
        void success(String s);

        void failed(String s);

        void getname(String s);

        void getpwd(String s);


        void confrim(String s);
    }
}
