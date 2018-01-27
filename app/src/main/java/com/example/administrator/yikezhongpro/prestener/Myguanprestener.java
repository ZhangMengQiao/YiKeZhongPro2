package com.example.administrator.yikezhongpro.prestener;

import com.example.administrator.yikezhongpro.bean.MyguanzhuBean;
import com.example.administrator.yikezhongpro.model.MyguanzhuModel;


/**
 * 趁年轻 创建于 2018/1/26.
 */

public class Myguanprestener {
    IMyguanView iMyguanView;
    MyguanzhuModel myguanzhuModel;

    public Myguanprestener(IMyguanView iMyguanView) {
        this.iMyguanView = iMyguanView;
        myguanzhuModel=new MyguanzhuModel();
    }

    public void getData(){
        myguanzhuModel.getData(new MyguanzhuModel.IMyguanzhuModel() {
            @Override
            public void success(MyguanzhuBean myguanzhuBean) {
                if(iMyguanView!=null){
                    iMyguanView.success(myguanzhuBean);
                }
            }
        });
    }
    public interface IMyguanView{
        void success(MyguanzhuBean myguanzhuBean);
    }
}
