package com.example.administrator.yikezhongpro.model;

import com.example.administrator.yikezhongpro.bean.DuanziBean;
import com.example.administrator.yikezhongpro.retrofit.BaseObserver;
import com.example.administrator.yikezhongpro.retrofit.RetrofitManager;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 趁年轻 创建于 2018/1/22.
 */

public class DuanziModel {

    public void getData(String page,final IDuanziModel iDuanziModel){
        Map<String,String> map = new HashMap<>();
        map.put("page",page);
        map.put("source","android");
        map.put("appVersion","101");
        RetrofitManager.get("quarter/getJokes",map, new BaseObserver<DuanziBean>() {
            @Override
            public void success(DuanziBean duanziBean) {
                if(iDuanziModel!=null){
                    iDuanziModel.success(duanziBean);
                }
            }

            @Override
            public void failure(int code) {

            }
        });
    }



    public interface IDuanziModel{
        void  success(DuanziBean duanziBean);
    }

}
