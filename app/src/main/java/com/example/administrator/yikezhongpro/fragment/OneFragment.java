package com.example.administrator.yikezhongpro.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import com.example.administrator.yikezhongpro.R;
import com.example.administrator.yikezhongpro.adapter.Find_tab_Adapter;
import com.example.administrator.yikezhongpro.fragment.fragment.Guanzhu;
import com.example.administrator.yikezhongpro.fragment.fragment.Remen;

import io.reactivex.annotations.Nullable;


/**
 * 趁年轻 创建于 2018/1/22.
 */

public class OneFragment extends Fragment {
    private TabLayout tab_FindFragment_title; //定义TabLayout
    private ViewPager vp_FindFragment_pager; //定义viewPager
    private FragmentPagerAdapter fAdapter; //定义adapter
    private List<Fragment> list_fragment; //定义要装fragment的列表
    private List<String> list_title; //tab名称列表
    private Remen hotRecommendFragment; //热门推荐fragment
    private Guanzhu hotCollectionFragment; //热门收藏fragment


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.onfragment, container, false);

        initControls(view);
        return view;
    }

    private void initControls(View view) {
        tab_FindFragment_title = (TabLayout) view.findViewById(R.id.tab_FindFragment_title);
        vp_FindFragment_pager = (ViewPager) view.findViewById(R.id.vp_FindFragment_pager);
        //初始化各fragment
        hotRecommendFragment = new Remen();
        hotCollectionFragment = new Guanzhu();
        list_fragment = new ArrayList<>();
        list_fragment.add(hotRecommendFragment);
        list_fragment.add(hotCollectionFragment);


        //将名称加载tab名字列表，正常情况下，我们应该在values/arrays.xml中进行定义然后调用
        list_title = new ArrayList<>();
        list_title.add("热门");
        list_title.add("关注");

        //设置TabLayout的模式
        tab_FindFragment_title.setTabMode(TabLayout.MODE_FIXED);
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(0)));
        tab_FindFragment_title.addTab(tab_FindFragment_title.newTab().setText(list_title.get(1)));
        fAdapter = new Find_tab_Adapter(getActivity().getSupportFragmentManager(), list_fragment, list_title);
        //viewpager加载adapter
        vp_FindFragment_pager.setAdapter(fAdapter);
        tab_FindFragment_title.setupWithViewPager(vp_FindFragment_pager);

    }
}