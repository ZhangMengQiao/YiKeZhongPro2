package com.example.administrator.yikezhongpro.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.yikezhongpro.MainActivity;
import com.example.administrator.yikezhongpro.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FabuActivity extends AppCompatActivity {

    @BindView(R.id.fb_quxiao)
    TextView fbQuxiao;
    @BindView(R.id.fb_duanzi)
    SimpleDraweeView fbDuanzi;
    @BindView(R.id.fb_shipin)
    SimpleDraweeView fbShipin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabu);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.fb_quxiao, R.id.fb_duanzi, R.id.fb_shipin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fb_quxiao:
                Intent intent=new Intent(FabuActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.fb_duanzi:
                Intent intent1=new Intent(FabuActivity.this, FabuDuanziActivity.class);
                startActivity(intent1);
                break;
            case R.id.fb_shipin:
                break;
        }
    }
}
