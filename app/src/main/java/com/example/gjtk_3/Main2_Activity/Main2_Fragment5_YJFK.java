package com.example.gjtk_3.Main2_Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gjtk_3.Main2_Activity.bean.Main2_Fragment5_bean;
import com.example.gjtk_3.MainActivity2;
import com.example.gjtk_3.R;

import java.util.ArrayList;

public class Main2_Fragment5_YJFK extends AppCompatActivity {

    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private EditText biaoTi;
    private EditText neiRong;
    private EditText shouJi;
    private ArrayList<Main2_Fragment5_bean> yjfks=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_fragment5_yjfk);
        initView();
        ivFh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void setHuoQu(){
        String a=biaoTi.getText().toString();
        String b=neiRong.getText().toString();
        String c=shouJi.getText().toString();
        yjfks.add(new Main2_Fragment5_bean().setBiaoTi(a).setShouJi(b).setYiJian(c));
    }
    public void dianJi(View view){
        setHuoQu();

        if (biaoTi.getText().toString().trim().isEmpty()||neiRong.getText().toString().trim().isEmpty()||shouJi.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"请提交内容",Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent=new Intent(this, MainActivity2.class);
            intent.putExtra("123",yjfks);
            startActivity(intent);}
    }
    public void TiJiao(View view){
        if (biaoTi.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"标题不能为空",Toast.LENGTH_SHORT).show();
        }else if (neiRong.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"内容不能为空",Toast.LENGTH_SHORT).show();
        }else if (shouJi.getText().toString().trim().isEmpty()){
            Toast.makeText(this,"手机号码不能为空",Toast.LENGTH_SHORT).show();
        }
        else {
            setDialog();
            Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();
        }
    }
    private ProgressDialog dialog;

    private void setDialog(){
        dialog=new ProgressDialog(this);
        dialog.setTitle("正在提交");
        dialog.setMessage("上传中.....");
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long time=System.currentTimeMillis();
                int p=0;
                while (System.currentTimeMillis()-time<1000){
                    try {
                        p+=10;
                        dialog.setProgress(p);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                dialog.dismiss();
            }
        }).start();
    }//弹窗
    private void initView() {
        ivFh = findViewById(R.id.iv_fh);
        title1 = findViewById(R.id.title1);
        tvGrzx = findViewById(R.id.tv_grzx);
        biaoTi = findViewById(R.id.biaoTi);
        neiRong = findViewById(R.id.neiRong);
        shouJi = findViewById(R.id.shouJi);
    }
}