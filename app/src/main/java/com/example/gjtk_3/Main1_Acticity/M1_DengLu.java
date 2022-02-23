package com.example.gjtk_3.Main1_Acticity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gjtk_3.MainActivity2;
import com.example.gjtk_3.R;
import com.example.gjtk_3.net.App;
import com.example.gjtk_3.net.OkHttpLo;
import com.example.gjtk_3.net.OkHttpTo;

import org.json.JSONObject;

import java.io.IOException;

public class M1_DengLu extends AppCompatActivity {

    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private EditText zhanghao;
    private EditText mima;
    private Button DL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1_deng_lu);
        initView();
        title1.setText("登录界面");
        DL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String zh = zhanghao.getText().toString().trim();
                String mm = mima.getText().toString().trim();
                Log.d(TAG, "DengLu: wwwww");
                DengLu2(zh, mm);
                System.out.println("123");
            }
        });

    }
    public static final String TAG="M1_DengLu";
    public void DengLu2(String zh,String mm) {
        new OkHttpTo()
                .setUrl("/prod-api/api/login")
                .setType("POST")
                .setJsonObject("username", zh)
                .setJsonObject("password", mm)
                .setOkHttpLo(new OkHttpLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Log.d(TAG, "HuoQu: " + jsonObject.toString());
                        if (jsonObject.optString("code").equals("200")) {
                            App.setToken(jsonObject.optString("token"));
                            Intent intent = new Intent(M1_DengLu.this, MainActivity2.class);
                            startActivity(intent);
                            Toast.makeText(M1_DengLu.this, "登陆成功", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(M1_DengLu.this, "请重新输入账号密码", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(IOException e) {

                    }
                }).start();

    }

    private void initView() {
        DL = findViewById(R.id.DL);
        ivFh = findViewById(R.id.iv_fh);
        title1 = findViewById(R.id.title1);
        tvGrzx = findViewById(R.id.tv_grzx);
        zhanghao = findViewById(R.id.zhanghao);
        mima = findViewById(R.id.mima);
    }
}