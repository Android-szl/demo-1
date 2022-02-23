package com.example.gjtk_3.Main2_Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gjtk_3.R;

public class XiuGaiMiMa extends AppCompatActivity {

    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private EditText mm1;
    private EditText mm2;
    private EditText mm3;
    private Button butt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiu_gai_mi_ma);
        initView();
        title1.setText("修改密码");
        ivFh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void button(View view){
        if (mm1.getText().toString().trim().isEmpty()||mm2.getText().toString().trim().isEmpty()||mm3.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"请填写所有内容",Toast.LENGTH_SHORT).show();
        }{
            Toast.makeText(this,"修改成功",Toast.LENGTH_SHORT).show();
//            butt1.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    finish();
//                }
//            });
        }
    }
    private void initView() {
        ivFh = findViewById(R.id.iv_fh);
        title1 = findViewById(R.id.title1);
        tvGrzx = findViewById(R.id.tv_grzx);
        mm1 = findViewById(R.id.mm1);
        mm2 = findViewById(R.id.mm2);
        mm3 = findViewById(R.id.mm3);
        butt1 = findViewById(R.id.butt1);
    }
}