package com.example.gjtk_3.Main1_Acticity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gjtk_3.Main2_Activity.F1_Adapter.BusStopAdapter;
import com.example.gjtk_3.Main2_Activity.bean.JKsj;
import com.example.gjtk_3.R;
import com.example.gjtk_3.net.OkHttpLo;
import com.example.gjtk_3.net.OkHttpTo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BusStop extends AppCompatActivity {

    private ImageView ivFh;
    private TextView tvGrzx;
    private ListView newlist;
    private BusStopAdapter adapter;
    private ArrayList<JKsj> jKsjs = new ArrayList<>();
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_stop);
        initView();
        SJ();
        setDialog();
        ivFh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        tvGrzx.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SJ();
//            }
//        });

    }
    public void clickkk(View view){
        setDialog();
    }
    private void setDialog() {
        dialog = new ProgressDialog(this);
        dialog.setTitle("当前账户没有停车记录");
        dialog.setMessage("加载中.....");
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        dialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long time = System.currentTimeMillis();
                int p = 0;
                while (System.currentTimeMillis() - time < 1000) {
                    try {
                        p += 10;
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

    public void SJ() {
        new OkHttpTo()
                .setUrl("/prod-api/api/park/lot/list")
                .setType("GET")
                .setOkHttpLo(new OkHttpLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        jKsjs = new Gson().fromJson(jsonObject.optJSONArray("rows").toString(), new TypeToken<List<JKsj>>() {
                        }.getType());
                        if (jKsjs.size()!=0){
                            adapter=new BusStopAdapter(BusStop.this,jKsjs);
                            newlist.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(IOException e) {

                    }
                }).start();
    }

    private void initView() {
        ivFh = findViewById(R.id.iv_fh);
        tvGrzx = findViewById(R.id.tv_grzx2);
        newlist = findViewById(R.id.newlist);
    }
}