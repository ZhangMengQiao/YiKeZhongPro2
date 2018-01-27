package com.example.administrator.yikezhongpro.view;

import android.content.Intent;
import android.net.wifi.hotspot2.omadm.PpsMoParser;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.yikezhongpro.MainActivity;
import com.example.administrator.yikezhongpro.R;
import com.example.administrator.yikezhongpro.prestener.RegistPrestener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements RegistPrestener.IRegistView {

    @BindView(R.id.image_login_fan)
    ImageView imageLoginFan;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.imageView5)
    ImageView imageView5;
    @BindView(R.id.et_mobile)
    EditText etMobile;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.bt_register)
    Button btRegister;
    @BindView(R.id.text_zhu_youke)
    TextView textZhuYouke;

    private RegistPrestener registPrestener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        registPrestener = new RegistPrestener(this);
    }

    @OnClick({R.id.image_login_fan, R.id.tv_register, R.id.imageView5, R.id.et_mobile, R.id.et_password, R.id.bt_register, R.id.text_zhu_youke})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_login_fan:
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_register:
                Intent intent1 = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.imageView5:
                break;
            case R.id.bt_register:

                String mobile = etMobile.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                registPrestener.getData(mobile, password);
                break;
            case R.id.text_zhu_youke:
                Intent intent2 = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent2);
                break;
        }
    }

    @Override
    public void success(String s) {
        if (("注册成功").equals(s)) {
            Toast.makeText(RegisterActivity.this, s, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(RegisterActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void failed(String s) {
        Toast.makeText(RegisterActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getname(String s) {
        Toast.makeText(RegisterActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getpwd(String s) {
        Toast.makeText(RegisterActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void confrim(String s) {
        Toast.makeText(RegisterActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        registPrestener.detach();
    }
}
