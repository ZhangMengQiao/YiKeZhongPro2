package com.example.administrator.yikezhongpro.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.yikezhongpro.MainActivity;
import com.example.administrator.yikezhongpro.R;

public class ShouYeActivity extends AppCompatActivity {

    private Handler handler = new Handler() {
    };
    private int time = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shou_ye);
        handler.postDelayed(runnable, 1000);
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            time--;
            handler.postDelayed(runnable, 1000);
            if (time == 0) {
                Intent intent = new Intent(ShouYeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };

}
