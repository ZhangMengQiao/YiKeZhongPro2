package com.example.administrator.yikezhongpro.prestener;

import com.example.administrator.yikezhongpro.bean.DuanziBean;
import com.example.administrator.yikezhongpro.bean.Lunbo;
import com.example.administrator.yikezhongpro.model.LunboModel;

/**
 * 趁年轻 创建于 2018/1/24.
 */

public class LunboPrestener {
    ILunboView iLunboView;
    LunboModel lunboModel;

    public LunboPrestener(ILunboView iLunboView) {
        this.iLunboView = iLunboView;
        lunboModel=new LunboModel();
    }
    public void getData(){
        lunboModel.getData(new LunboModel.ILunboModel() {
            @Override
            public void success(Lunbo lunbo) {
                if(iLunboView!=null){
                    iLunboView.success(lunbo);
                }
            }
        });
    }

    public interface ILunboView{
        void success(Lunbo lunbo);
    }
}
