package com.example.gjtk_3.Main2_Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gjtk_3.Main2_Activity.F1_Adapter.GridAdapter;
import com.example.gjtk_3.Main2_Activity.F2_Adapter.FL_Adapter;
import com.example.gjtk_3.Main2_Activity.F2_Adapter.GridAdapter3;
import com.example.gjtk_3.Main2_Activity.bean.QBFW;
import com.example.gjtk_3.R;
import com.example.gjtk_3.net.App;
import com.example.gjtk_3.net.OkHttpLo;
import com.example.gjtk_3.net.OkHttpTo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main2_fragment2 extends Fragment {
    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private ListView listView;
    private GridView gridView;
    private ArrayList<QBFW>qbfws=new ArrayList<>();
    private ArrayList<QBFW>qb_sx=new ArrayList<>();
    private ArrayList<String>fwmz=new ArrayList<>();
    private FL_Adapter adapter;
    private GridAdapter3 adapter2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main2_fragment2, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        getFW();
        ivFh.setVisibility(View.INVISIBLE);
        title1.setText("全部服务");
    }
    public void getFW(){
        new OkHttpTo()
                .setUrl("/prod-api/api/service/list")
                .setToken(App.getToken())
                .setType("GET")
                .setOkHttpLo(new OkHttpLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        qbfws = new Gson().fromJson(jsonObject.optJSONArray("rows").toString(), new TypeToken<List<QBFW>>() {
                        }.getType());
                        fwm();
                    }

                    @Override
                    public void onFailure(IOException e) {

                    }


                }).start();
    }

    public void fwm() {
        for (int i = 0; i < qbfws.size(); i++) {
            fwmz.add(qbfws.get(i).getServiceType());
        }
        for (int i = 0; i < fwmz.size(); i++) {
            for (int o = fwmz.size() - 1; o > i; o--) {
                if (fwmz.get(i).equals(fwmz.get(o))) {
                    fwmz.remove(o);
                }
            }
        }
        setList();
    }
    public void setList() {
        if (adapter == null) {
            adapter = new FL_Adapter(getContext(), fwmz);
            adapter.setClick(new GridAdapter.Click() {
                @Override
                public void Clicks(int position, String name) {
                    setGrid(name);
                }
            });
        } else {
            adapter.notifyDataSetChanged();
        }
        listView.setAdapter(adapter);
    }

    private void setGrid(String name) {
        qb_sx.clear();
        for (int i = 0; i < qbfws.size(); i++) {
            if (qbfws.get(i).getServiceType().equals(name)) {
                qb_sx.add(qbfws.get(i));
            }
        }
        if (adapter2 == null) {
            adapter2 = new GridAdapter3(getContext(), qb_sx);
            adapter2.setOnclick(new  GridAdapter.Click() {
                @Override
                public void Clicks(int position, String name) {
                }
            });
        } else {
            adapter2.notifyDataSetChanged();
        }
        gridView.setAdapter(adapter2);

    }
    private void initView() {
        ivFh = getView().findViewById(R.id.iv_fh);
        title1 = getView().findViewById(R.id.title1);
        tvGrzx = getView().findViewById(R.id.tv_grzx);
        listView = getView().findViewById(R.id.list_view);
        gridView = getView().findViewById(R.id.grid_view);
    }
}
