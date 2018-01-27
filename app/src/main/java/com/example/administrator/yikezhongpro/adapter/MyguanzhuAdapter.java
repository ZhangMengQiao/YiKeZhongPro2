package com.example.administrator.yikezhongpro.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.yikezhongpro.R;
import com.example.administrator.yikezhongpro.bean.MyguanzhuBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 趁年轻 创建于 2018/1/26.
 */

public class MyguanzhuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<MyguanzhuBean.DataBean> list;

    public MyguanzhuAdapter(Context context, List<MyguanzhuBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_guanzhu, parent, false);
        HoldView holdView = new HoldView(view);

        return holdView;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        MyguanzhuBean.DataBean dataBean = list.get(position);
        ((HoldView) holder).my_text.setText(dataBean.getNickname()+"");
        ((HoldView) holder).my_zishijian.setText(dataBean.getCreatetime());
        ((HoldView) holder).my_zigexing.setText(dataBean.getMobile());
        ((HoldView) holder).my_zitouxaing.setImageURI(dataBean.getIcon()+"");

    }

    @Override
    public int getItemCount() {
        return list == null? 0:list.size();
    }

    private class HoldView extends RecyclerView.ViewHolder {

        private TextView my_text;
        TextView my_zigexing;
        TextView my_zishijian;
        SimpleDraweeView my_zitouxaing;

        public HoldView(View itemView) {
            super(itemView);
            my_text = itemView.findViewById(R.id.my_text);
            my_zigexing = itemView.findViewById(R.id.my_zigexing);
            my_zishijian = itemView.findViewById(R.id.my_zishijian);
            my_zitouxaing = itemView.findViewById(R.id.my_zitouxaing);



        }
    }

}
