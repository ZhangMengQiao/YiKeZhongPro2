package com.example.administrator.yikezhongpro.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.yikezhongpro.R;
import com.example.administrator.yikezhongpro.bean.DuanziBean;
import com.example.administrator.yikezhongpro.fragment.TwoFragment;
import com.example.administrator.yikezhongpro.prestener.DianjiguanzhuPre;
import com.example.administrator.yikezhongpro.prestener.Duanziperstener;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.OnItemClick;

/**
 * 趁年轻 创建于 2018/1/22.
 */

public class DuanZiaAapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<DuanziBean.DataBean> list;
    DianjiguanzhuPre dianjiguanzhuPre;
    public DuanZiaAapter(Context context, List<DuanziBean.DataBean> list, DianjiguanzhuPre dianjiguanzhuPre) {
        this.context = context;
        this.list = list;
        this.dianjiguanzhuPre=dianjiguanzhuPre;

    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.duanzi_item, parent, false);
        HoldView holdView = new HoldView(view);
        return holdView;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        DuanziBean.DataBean dataBean = list.get(position);
        ((HoldView) holder).duanzi_name.setText(dataBean.getUser().getNickname());
        ((HoldView) holder).duanzi_shijian.setText(dataBean.getCreateTime());
        ((HoldView) holder).duanzi_neirong.setText(dataBean.getContent());
        ((HoldView) holder).duanzi_tou.setImageURI(dataBean.getUser().getIcon());
        ((HoldView) holder).duanzi_donghua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"1",Toast.LENGTH_SHORT).show();
                int uid = list.get(position).getUid();

                dianjiguanzhuPre.getData(uid+"");

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class HoldView extends RecyclerView.ViewHolder {

        private TextView duanzi_name;
        private TextView duanzi_neirong;
        private SimpleDraweeView duanzi_tou;
        private TextView duanzi_shijian;
        private ImageView duanzi_donghua;




        public HoldView(View itemView) {
            super(itemView);
            duanzi_name = itemView.findViewById(R.id.duanzi_name);
            duanzi_donghua = itemView.findViewById(R.id.duanzi_donghua);
            duanzi_neirong = itemView.findViewById(R.id.duanzi_neirong);
            duanzi_shijian = itemView.findViewById(R.id.duanzi_shijian);
            duanzi_tou = itemView.findViewById(R.id.duanzi_tou);

        }
    }

}
