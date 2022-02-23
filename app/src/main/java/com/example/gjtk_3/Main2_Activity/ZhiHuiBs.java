package com.example.gjtk_3.Main2_Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gjtk_3.Main2_Activity.F1_Adapter.BusStopAdapter;
import com.example.gjtk_3.Main2_Activity.F1_Adapter.ZHBS_Adapter;
import com.example.gjtk_3.Main2_Activity.bean.CD;
import com.example.gjtk_3.R;
import com.example.gjtk_3.net.OkHttpLo;
import com.example.gjtk_3.net.OkHttpTo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ZhiHuiBs extends AppCompatActivity {

    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private ListView listView;
    private ZHBS_Adapter adapter;
    private ArrayList<CD>cds=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhi_hui_bs);
        initView();
        title1.setText("智慧巴士");
        tvGrzx.setText("历史订单");
        ivFh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ZHBS();
        tvGrzx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ZhiHuiBs.this,"当前暂无订单",Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setDialog();
                Toast.makeText(ZhiHuiBs.this,"网络加载失败",Toast.LENGTH_SHORT).show();

            }
        });
    }
    private ProgressDialog dialog;

    private void setDialog() {
        dialog = new ProgressDialog(this);
        dialog.setTitle("网络加载");
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
    public void ZHBS(){
        new OkHttpTo()
                .setUrl("/prod-api/api/bus/line/list")
                .setType("GET")
                .setOkHttpLo(new OkHttpLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        cds = new Gson().fromJson(jsonObject.optJSONArray("rows").toString(), new TypeToken<List<CD>>() {
                        }.getType());
                        if (cds.size()!=0){
                            adapter=new ZHBS_Adapter(ZhiHuiBs.this,cds);
                            listView.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(IOException e) {

                    }

                }).start();
    }

    private void initView() {
        ivFh = findViewById(R.id.iv_fh);
        title1 = findViewById(R.id.title1);
        tvGrzx = findViewById(R.id.tv_grzx);
        listView = findViewById(R.id.list_view);
    }
}