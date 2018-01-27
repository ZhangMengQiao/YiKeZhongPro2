package com.example.administrator.yikezhongpro.prestener;

import com.example.administrator.yikezhongpro.bean.VideosBean;
import com.example.administrator.yikezhongpro.model.VideosModel;

/**
 * 趁年轻 创建于 2018/1/25.
 */

public class VideosPresenter {
    IVideoView iVideoView;
    VideosModel videosModel;

    public VideosPresenter(IVideoView iVideoView) {
        this.iVideoView = iVideoView;
        videosModel=new VideosModel();
    }
    public void getData(){
        videosModel.getData(new VideosModel.IVideosModel() {
            @Override
            public void scuccess(VideosBean videosBean) {
                iVideoView.success(videosBean);
            }
        });
    }

    public interface IVideoView{
        void success(VideosBean videosBean);
    }
}
