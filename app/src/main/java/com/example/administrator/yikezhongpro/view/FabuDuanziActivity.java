package com.example.administrator.yikezhongpro.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.yikezhongpro.MainActivity;
import com.example.administrator.yikezhongpro.R;
import com.example.administrator.yikezhongpro.bean.RegistBean;
import com.example.administrator.yikezhongpro.prestener.FaBuduanziPrestener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FabuDuanziActivity extends AppCompatActivity implements FaBuduanziPrestener.IFFaBuduanziView {

    @BindView(R.id.fb_quxiao)
    TextView fbQuxiao;
    @BindView(R.id.fb_fabiao)
    TextView fbFabiao;
    @BindView(R.id.et_neirong)
    EditText etNeirong;

    private FaBuduanziPrestener faBuduanziPrestener;
    private String trim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fabu_duanzi);
        ButterKnife.bind(this);
        faBuduanziPrestener = new FaBuduanziPrestener(this);
    }

    @OnClick({R.id.fb_quxiao, R.id.fb_fabiao, R.id.et_neirong})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fb_quxiao:
                Intent intent = new Intent(FabuDuanziActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.fb_fabiao:
                String trim1= etNeirong.getText().toString().trim();
                faBuduanziPrestener.getData(trim1);
                break;
            case R.id.et_neirong:
                break;
        }
    }

    @Override
    public void success(RegistBean registBean) {

    }

    @Override
    public void getneirong(String s) {
        Toast.makeText(FabuDuanziActivity.this,s,Toast.LENGTH_SHORT).show();
    }
}
