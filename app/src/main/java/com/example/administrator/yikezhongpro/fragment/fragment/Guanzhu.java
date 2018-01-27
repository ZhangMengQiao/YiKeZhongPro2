package com.example.administrator.yikezhongpro.fragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.yikezhongpro.R;
import com.example.administrator.yikezhongpro.adapter.VideosAdapter;
import com.example.administrator.yikezhongpro.bean.VideosBean;
import com.example.administrator.yikezhongpro.prestener.VideosPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Guanzhu extends Fragment implements VideosPresenter.IVideoView{

    @BindView(R.id.videos_rc)
    RecyclerView videosRc;
    Unbinder unbinder;

    private VideosPresenter videosPresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.guanzhu, container, false);
        unbinder = ButterKnife.bind(this, view);
        videosPresenter=new VideosPresenter(this);
        videosPresenter.getData();
        return view;

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
}
