package com.example.administrator.yikezhongpro.view.myView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.yikezhongpro.MainActivity;
import com.example.administrator.yikezhongpro.R;
import com.example.administrator.yikezhongpro.adapter.MyguanzhuAdapter;
import com.example.administrator.yikezhongpro.bean.MyguanzhuBean;
import com.example.administrator.yikezhongpro.prestener.Myguanprestener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyguanzhuActivity extends AppCompatActivity implements Myguanprestener.IMyguanView {

    @BindView(R.id.my_fanhui)
    TextView myFanhui;
    @BindView(R.id.my_remen)
    TextView myRemen;
    @BindView(R.id.my_listview)
    RecyclerView myListview;

    private Myguanprestener myguanprestener;
    private MyguanzhuAdapter myguanzhuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myguanzhu);
        ButterKnife.bind(this);
        myguanprestener = new Myguanprestener(this);
        myguanprestener.getData();
    }

    @OnClick({R.id.my_fanhui, R.id.my_remen})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_fanhui:
                Intent intent = new Intent(MyguanzhuActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.my_remen:

                break;
        }
    }

    @Override
    public void success(MyguanzhuBean myguanzhuBean) {
//适配器
        //Toast.makeText(this,myguanzhuBean.getData().get(0).getUsername(),Toast.LENGTH_LONG).show();
          myListview.setLayoutManager(new LinearLayoutManager(this));
        myguanzhuAdapter = new MyguanzhuAdapter(MyguanzhuActivity.this,myguanzhuBean.getData());
        myListview.setAdapter(myguanzhuAdapter);

    }
}
