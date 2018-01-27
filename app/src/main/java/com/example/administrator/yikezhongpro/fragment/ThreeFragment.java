package com.example.administrator.yikezhongpro.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.yikezhongpro.R;
import com.example.administrator.yikezhongpro.adapter.VideosAdapter2;
import com.example.administrator.yikezhongpro.bean.VideosBean;
import com.example.administrator.yikezhongpro.prestener.VideosPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.annotations.Nullable;

/**
 * 趁年轻 创建于 2018/1/22.
 */

public class ThreeFragment extends Fragment implements VideosPresenter.IVideoView {
    @BindView(R.id.rc)
    RecyclerView rc;
    Unbinder unbinder;

    private VideosPresenter videosPresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.threefragment, container, false);
        videosPresenter=new VideosPresenter(this);
        unbinder = ButterKnife.bind(this, view);
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
        rc.setLayoutManager(new StaggeredGridLayoutManager(2,  StaggeredGridLayoutManager.VERTICAL));
        VideosAdapter2 videosAdapter = new VideosAdapter2(getActivity(), videosBean.getData());
        rc.setAdapter(videosAdapter);
    }
}
