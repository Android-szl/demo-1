package com.example.gjtk_3.Main2_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gjtk_3.MainActivity;
import com.example.gjtk_3.R;

public class Main2_Fragment5_GRZX extends AppCompatActivity {

    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private Button btnm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_fragment5_grzx);
        initView();
        title1.setText("个人信息");
        ivFh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2_Fragment5_GRZX.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        ivFh = findViewById(R.id.iv_fh);
        title1 = findViewById(R.id.title1);
        tvGrzx = findViewById(R.id.tv_grzx);
        btnm = findViewById(R.id.btnm);
    }
}