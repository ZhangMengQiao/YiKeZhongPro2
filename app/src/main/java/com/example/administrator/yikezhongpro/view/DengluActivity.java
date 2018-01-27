package com.example.administrator.yikezhongpro.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.yikezhongpro.MainActivity;
import com.example.administrator.yikezhongpro.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DengluActivity extends AppCompatActivity {
    @BindView(R.id.image_fan)
    ImageView imageFan;
    @BindView(R.id.textView3)
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.image_fan, R.id.textView3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image_fan:
                Intent intent = new Intent(DengluActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.textView3:
                Intent intent1 = new Intent(DengluActivity.this, LoginActivity.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left);
                break;
        }
    }
}
