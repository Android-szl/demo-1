package com.example.gjtk_3;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.gjtk_3.Main2_Activity.bean.XWLB1;

public class NewDetailActivity extends AppCompatActivity {

    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private TextView tvName;
    private ImageView ivNew;
    private TextView tvContent;
    private XWLB1 xwlb1s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_detail);
        initView();
        ivFh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        title1.setText("新闻详情");
        xwlb1s=(XWLB1) getIntent().getSerializableExtra("xw");
//        setText("\u3000\u3000"+xxxxx);
        tvContent.setText(Html.fromHtml(xwlb1s.getContent()));
        tvName.setText("\u3000\u3000"+xwlb1s.getTitle());
        Glide.with(this).load("http://124.93.196.45:10001" +xwlb1s.getCover()).into(ivNew);
    }

    private void initView() {
        ivFh = findViewById(R.id.iv_fh);
        title1 = findViewById(R.id.title1);
        tvGrzx = findViewById(R.id.tv_grzx);
        tvName = findViewById(R.id.tv_name);
        ivNew = findViewById(R.id.iv_new);
        tvContent = findViewById(R.id.tv_content);
    }
}