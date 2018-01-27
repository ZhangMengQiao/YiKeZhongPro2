package com.example.administrator.yikezhongpro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.yikezhongpro.fragment.OneFragment;
import com.example.administrator.yikezhongpro.fragment.ThreeFragment;
import com.example.administrator.yikezhongpro.fragment.TwoFragment;
import com.example.administrator.yikezhongpro.view.DengluActivity;
import com.example.administrator.yikezhongpro.view.FabuActivity;
import com.example.administrator.yikezhongpro.view.myView.MyguanzhuActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;


public class MainActivity extends AppCompatActivity {


    private DrawerLayout drawerLayout;

    LinearLayout dr_letf;
    private TextView title;
    private TextView my_guanzhu;
    private ImageView btn_right;
    //头像
    SimpleDraweeView cl_imageview;
    TextView cl_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SimpleDraweeView iv_left = findViewById(R.id.iv_left);
        drawerLayout = findViewById(R.id.drawerLayout);
        dr_letf = findViewById(R.id.dr_left);
        btn_right = findViewById(R.id.btn_right);
        my_guanzhu = findViewById(R.id.my_guanzhu);
        cl_imageview = findViewById(R.id.cl_imageView);
        cl_name = findViewById(R.id.cl_name);
        title = findViewById(R.id.tv_title);
        drawerLayout.openDrawer(dr_letf);
        iv_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(dr_letf);
            }
        });
        RelativeLayout real = drawerLayout.findViewById(R.id.rela);
        cl_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DengluActivity.class);
                startActivity(intent);
            }
        });
        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FabuActivity.class);
                startActivity(intent);
            }
        });


        my_guanzhu.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyguanzhuActivity.class);
                startActivity(intent);
            }
        });

        //头像
        cl_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"1",Toast.LENGTH_SHORT).show();
            }
        });
        //底部导航
        BottomTabBar btbar = findViewById(R.id.btbar);
        btbar.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(10)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.BLUE, Color.DKGRAY)
                .addTabItem("推荐", R.drawable.tuijian, OneFragment.class)
                .addTabItem("段子", R.drawable.duanzi, TwoFragment.class)
                .addTabItem("视频", R.drawable.shipin, ThreeFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
        btbar.setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
            @Override
            public void onTabChange(int position, String name) {
                switch (position) {
                    case 0:
                        title.setText("推荐");
                        break;
                    case 1:
                        title.setText("段子");
                        break;
                    case 2:
                        title.setText("视频");
                        break;
                }
            }
        });
    }


}
