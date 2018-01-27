package com.example.administrator.yikezhongpro.prestener;

import com.example.administrator.yikezhongpro.bean.RegistBean;
import com.example.administrator.yikezhongpro.model.DianjiguanzhuModle;

/**
 * 趁年轻 创建于 2018/1/27.
 */

public class DianjiguanzhuPre {
    IDianjiguanzhuView iDianjiguanzhuView;
    DianjiguanzhuModle dianjiguanzhuModle;

    public DianjiguanzhuPre(IDianjiguanzhuView iDianjiguanzhuView) {
        this.iDianjiguanzhuView = iDianjiguanzhuView;
        dianjiguanzhuModle = new DianjiguanzhuModle();
    }

    public void getData(String followId) {
        dianjiguanzhuModle.getData(followId, new DianjiguanzhuModle.IDianjiguanzhuModle() {
            @Override
            public void success(RegistBean registBean) {
                if(iDianjiguanzhuView!=null){
                    iDianjiguanzhuView.success(registBean.getMsg());
                }
            }
        });
    }

    public interface IDianjiguanzhuView {
        void success(RegistBean registBean);

        void success(String s);
    }
}
