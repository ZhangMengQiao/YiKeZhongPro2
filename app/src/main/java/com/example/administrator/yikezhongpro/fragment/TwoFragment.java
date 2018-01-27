package com.example.administrator.yikezhongpro.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.yikezhongpro.MainActivity;
import com.example.administrator.yikezhongpro.R;
import com.example.administrator.yikezhongpro.adapter.DuanZiaAapter;
import com.example.administrator.yikezhongpro.bean.DuanziBean;
import com.example.administrator.yikezhongpro.bean.RegistBean;
import com.example.administrator.yikezhongpro.prestener.DianjiguanzhuPre;
import com.example.administrator.yikezhongpro.prestener.Duanziperstener;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.annotations.Nullable;

/**
 * 趁年轻 创建于 2018/1/22.
 */

public class TwoFragment extends Fragment implements Duanziperstener.IDuanziView ,DianjiguanzhuPre.IDianjiguanzhuView{
    @BindView(R.id.xrc)
    XRecyclerView xrc;
    Unbinder unbinder;
    private TextView title;
    private DuanZiaAapter duanZiaAapter;
    private Duanziperstener duanziperstener;
     int i=1;


     private DianjiguanzhuPre dianjiguanzhuPre;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.twofragment, container, false);

        duanziperstener = new Duanziperstener(this);

        unbinder = ButterKnife.bind(this, view);
        duanziperstener.getData("1");
        dianjiguanzhuPre=new DianjiguanzhuPre(this);
        return view;
    }

    @Override
    public void onActivityCreated(@android.support.annotation.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        xrc.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                duanziperstener.getData("1");
                xrc.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                i++;
                String s = String.valueOf(i);
                duanziperstener.getData(s);
                xrc.loadMoreComplete();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void success(final DuanziBean duanziBean) {

        duanZiaAapter = new DuanZiaAapter(getActivity(), duanziBean.getData(),dianjiguanzhuPre);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrc.setLayoutManager(layoutManager);
        xrc.setAdapter(duanZiaAapter);


    }

    @Override
    public void success(RegistBean registBean) {

    }

    @Override
    public void success(String s) {
        Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
    }
}