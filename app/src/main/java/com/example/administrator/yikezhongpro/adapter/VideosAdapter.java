package com.example.administrator.yikezhongpro.adapter;
import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.yikezhongpro.R;
import com.example.administrator.yikezhongpro.bean.VideosBean;
import com.facebook.drawee.view.SimpleDraweeView;


import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 趁年轻 创建于 2018/1/25.
 */

public class VideosAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<VideosBean.DataBean> list;

    public VideosAdapter(Context context, List<VideosBean.DataBean> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.videos_item1,null);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder1 holder1 = (ViewHolder1) holder;
        holder1.name.setText(list.get(position).getUser().getNickname());
        holder1.tianqi.setText(list.get(position).getLatitude());
        holder1.time.setText(list.get(position).getCreateTime());
        boolean setUp = holder1.player.setUp("http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4", JCVideoPlayer.SCREEN_LAYOUT_LIST, "");
        if (setUp) {
            Glide.with(context).load(R.drawable.raw_1499917357).into(holder1.player.thumbImageView);
        }


    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView tianqi;
        private final SimpleDraweeView touxiang;
        private final TextView time;
        private final JCVideoPlayerStandard player;

        public ViewHolder1(View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.v_name);
            tianqi = itemView.findViewById(R.id.v_tianqi);
            touxiang = itemView.findViewById(R.id.v_touxiang);
            time = itemView.findViewById(R.id.v_time);
            player = (JCVideoPlayerStandard) itemView.findViewById(R.id.include);
        }
    }
}
