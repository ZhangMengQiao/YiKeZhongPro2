package com.example.administrator.yikezhongpro.view;

import android.content.Intent;
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
import com.example.administrator.yikezhongpro.prestener.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginPresenter.ILoginView {

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
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.text_wangji)
    TextView textWangji;
    @BindView(R.id.text_youke)
    TextView textYouke;
    private Intent intent;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);

    }

    @OnClick({R.id.image_login_fan, R.id.tv_register, R.id.bt_login, R.id.text_wangji, R.id.text_youke})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_login_fan:
                Intent intent1 = new Intent(LoginActivity.this, DengluActivity.class);
                startActivity(intent1);

                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                break;
            case R.id.tv_register:
                Intent intent2 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                break;
            //登录
            case R.id.bt_login:
                String mobile = etMobile.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                loginPresenter.getData(mobile, password);
                break;
            case R.id.text_wangji:
                Intent intent3= new Intent(LoginActivity.this, WangjiActivity.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
                break;
            case R.id.text_youke:
                intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

                break;
        }
    }

    @Override
    public void success(String s) {
        if ("登录成功".equals(s)) {
            Toast.makeText(LoginActivity.this, s, Toast.LENGTH_SHORT).show();
            //跳转到列表页面
            intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(LoginActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void failed(String s) {
        Toast.makeText(LoginActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getname(String s) {
        Toast.makeText(LoginActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getpwd(String s) {
        Toast.makeText(LoginActivity.this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detach();
    }
}
