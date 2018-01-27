package com.example.administrator.yikezhongpro.prestener;

import com.example.administrator.yikezhongpro.bean.RegistBean;
import com.example.administrator.yikezhongpro.model.FabuDuanziModel;

/**
 * 趁年轻 创建于 2018/1/26.
 */

public class FaBuduanziPrestener {
    IFFaBuduanziView ifFaBuduanziView;
    FabuDuanziModel fabuDuanziModel;

    public FaBuduanziPrestener(IFFaBuduanziView ifFaBuduanziView) {
        this.ifFaBuduanziView = ifFaBuduanziView;
        fabuDuanziModel=new FabuDuanziModel();
    }

    public void getData(String content){
        fabuDuanziModel.getData(content, new FabuDuanziModel.IFabuDuanModel() {
            @Override
            public void success(RegistBean registBean) {
                ifFaBuduanziView.getneirong(registBean.getMsg());
            }
        });
    }
    public interface IFFaBuduanziView{
        void success(RegistBean registBean);
        void getneirong(String s);
    }
}
