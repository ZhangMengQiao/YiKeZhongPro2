package com.example.administrator.yikezhongpro.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.yikezhongpro.MainActivity;
import com.example.administrator.yikezhongpro.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WangjiActivity extends AppCompatActivity {

    @BindView(R.id.image_login_fan)
    ImageView imageLoginFan;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.imageView5)
    ImageView imageView5;
    @BindView(R.id.et_mobile)
    EditText etMobile;
    @BindView(R.id.et_yanzhengma)
    EditText etYanzhengma;
    @BindView(R.id.bt_register)
    Button btRegister;
    @BindView(R.id.text_zhu_youke)
    TextView textZhuYouke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wangji);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.image_login_fan, R.id.tv_login, R.id.bt_register, R.id.text_zhu_youke})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_login_fan:
                Intent intent3 = new Intent(WangjiActivity.this, MainActivity.class);
                startActivity(intent3);
                break;
            case R.id.tv_login:
                Intent intent1 = new Intent(WangjiActivity.this, LoginActivity.class);
                startActivity(intent1);

                break;
            case R.id.bt_register:
                //输入手机号获取手机验证码

                break;
            case R.id.text_zhu_youke:
                Intent intent2 = new Intent(WangjiActivity.this, MainActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
