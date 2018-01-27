package com.example.administrator.yikezhongpro.fragment.fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.yikezhongpro.R;
import com.example.administrator.yikezhongpro.adapter.VideosAdapter;
import com.example.administrator.yikezhongpro.bean.Lunbo;
import com.example.administrator.yikezhongpro.bean.VideosBean;
import com.example.administrator.yikezhongpro.prestener.LunboPrestener;
import com.example.administrator.yikezhongpro.prestener.VideosPresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 趁年轻 创建于 2018/1/24.
 */

public class Remen extends Fragment implements LunboPrestener.ILunboView, OnBannerListener,VideosPresenter.IVideoView {
    @BindView(R.id.videos_rc)
    RecyclerView videosRc;
    Unbinder unbinder;
    private Banner banner1;
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
    private LunboPrestener lunboPrestener;
    private List<Lunbo.DataBean> data;

    private VideosPresenter videosPresenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.remen, container, false);
        banner1 = view.findViewById(R.id.banner1);
        lunboPrestener = new LunboPrestener(this);
        videosPresenter=new VideosPresenter(this);

        lunboPrestener.getData();
        videosPresenter.getData();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void success(Lunbo lunbo) {
        data = lunbo.getData();
        String icon = data.get(0).getIcon();
        String icon1 = data.get(1).getIcon();
        String icon2 = data.get(2).getIcon();
        String icon3 = data.get(3).getIcon();
        list_path = new ArrayList<>();
        //放标题的集合
        list_title = new ArrayList<>();
        list_path.add(icon);
        list_path.add(icon1);
        list_path.add(icon2);
        list_path.add(icon3);
        list_title.add("");
        list_title.add("");
        list_title.add("");
        list_title.add("");
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        banner1.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器，图片加载器在下方
        banner1.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        banner1.setImages(list_path);
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner1.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
        banner1.setBannerTitles(list_title);
        //设置轮播间隔时间
        banner1.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        banner1.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner1.setIndicatorGravity(BannerConfig.CENTER)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                .setOnBannerListener(this)
                //必须最后调用的方法，启动轮播图。
                .start();

    }

    //轮播图的监听方法
    @Override
    public void OnBannerClick(int position) {
        Log.i("tag", "你点了第" + position + "张轮播图");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void success(VideosBean videosBean) {
        videosRc.setLayoutManager(new LinearLayoutManager(getActivity()));
        VideosAdapter videosAdapter = new VideosAdapter(getActivity(), videosBean.getData());
        videosRc.setAdapter(videosAdapter);


    }

    //自定义的图片加载器
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }
}
