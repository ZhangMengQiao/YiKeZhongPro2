package com.example.administrator.yikezhongpro.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


import com.bumptech.glide.Glide;
import com.example.administrator.yikezhongpro.R;
import com.example.administrator.yikezhongpro.bean.VideosBean;


import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * 趁年轻 创建于 2018/1/25.
 */

public class VideosAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<VideosBean.DataBean> list;

    public VideosAdapter2(Context context, List<VideosBean.DataBean> list) {
        this.context = context;
        this.list = list;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.videos_item2,null);
        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder1 holder1 = (ViewHolder1) holder;
        boolean setUp = holder1.player.setUp(list.get(position).getVideoUrl(), JCVideoPlayer.SCREEN_LAYOUT_LIST, "");
        if (setUp) {
            Glide.with(context).load(R.drawable.raw_1499917357).into(holder1.player.thumbImageView);
        }

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder1 extends RecyclerView.ViewHolder {

        private final JCVideoPlayerStandard player;

        public ViewHolder1(View itemView) {
            super(itemView);

            player = (JCVideoPlayerStandard) itemView.findViewById(R.id.remen2_shipin);
        }
    }
}
