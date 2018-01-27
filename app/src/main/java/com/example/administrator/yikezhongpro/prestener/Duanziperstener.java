package com.example.administrator.yikezhongpro.prestener;

import com.example.administrator.yikezhongpro.bean.DuanziBean;
import com.example.administrator.yikezhongpro.model.DuanziModel;

/**
 * 趁年轻 创建于 2018/1/22.
 */

public class Duanziperstener {
    IDuanziView iDuanziView;
    DuanziModel duanziModel;

    public Duanziperstener(IDuanziView iDuanziView) {
        this.iDuanziView = iDuanziView;
        duanziModel=new DuanziModel();
    }
    public void getData(String page){
        duanziModel.getData(page, new DuanziModel.IDuanziModel() {
            @Override
            public void success(DuanziBean duanziBean) {
                if(iDuanziView!=null){
                    iDuanziView.success(duanziBean);
                }
            }
        });
    }

    public interface IDuanziView{
        void success(DuanziBean duanziBean);
    }
}
