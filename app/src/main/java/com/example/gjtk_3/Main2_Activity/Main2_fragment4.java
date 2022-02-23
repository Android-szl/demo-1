package com.example.gjtk_3.Main2_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.gjtk_3.Main2_Activity.F1_Adapter.XW1_Adapter;
import com.example.gjtk_3.Main2_Activity.bean.Type;
import com.example.gjtk_3.Main2_Activity.bean.XWLB1;
import com.example.gjtk_3.Main2_Activity.bean.XWLB2;
import com.example.gjtk_3.NewDetailActivity;
import com.example.gjtk_3.R;
import com.example.gjtk_3.net.App;
import com.example.gjtk_3.net.OkHttpLo;
import com.example.gjtk_3.net.OkHttpTo;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main2_fragment4 extends Fragment {
    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private ViewFlipper mainFlipper;
    private TabLayout newTab;
    private ListView newList;
    private ArrayList<XWLB2> xwlb2s;
    private ArrayList<XWLB1> xwlb1s = new ArrayList<>();
    private XW1_Adapter adapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        title1.setText("新闻");
        ivFh.setVisibility(View.INVISIBLE);
        getLBT();
        getXW();
        getVP3(9);
    }

    public void getLBT() {
        new OkHttpTo()
                .setUrl("/prod-api/api/park/press/press/list")
                .setType("GET")
                .setOkHttpLo(new OkHttpLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        xwlb2s = new Gson().fromJson(jsonObject.optJSONArray("rows").toString(), new TypeToken<List<XWLB2>>() {
                        }.getType());
                        setImage();
                    }

                    @Override
                    public void onFailure(IOException e) {

                    }
                }).start();
    }

    public void setImage() {
        for (int i = 0; i < xwlb2s.size(); i++) {
            ImageView imageView = new ImageView(requireContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            Glide.with(requireContext()).load("http://124.93.196.45:10001" + xwlb2s.get(i).getCover()).into(imageView);
            mainFlipper.addView(imageView);
        }
        mainFlipper.startFlipping();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main2_fragment4, null);
    }

    private List<Type> types;

    public void getXW() {
        new OkHttpTo()
                .setUrl("/prod-api/press/category/list")
                .setToken(App.getToken())
                .setType("GET")
                .setOkHttpLo(new OkHttpLo() {
                    @Override
                    public void onFailure(IOException e) {

                    }

                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        types = new Gson().fromJson(jsonObject.optJSONArray("data").toString(),
                                new TypeToken<List<Type>>() {
                                }.getType());
                        for (int i = 0; i < types.size(); i++) {
                            newTab.addTab(newTab.newTab().setText(types.get(i).getName()));
                        }
                        newTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                            @Override
                            public void onTabSelected(TabLayout.Tab tab) {
                                getVP3(types.get(tab.getPosition()).getId());
                            }

                            @Override
                            public void onTabUnselected(TabLayout.Tab tab) {
                            }

                            @Override
                            public void onTabReselected(TabLayout.Tab tab) {
                            }
                        });
                    }
                }).start();
    }

    public void getVP3(int id) {
        new OkHttpTo()
                .setUrl("/prod-api/press/press/list?type=" + id)
                .setToken(App.getToken())
                .setType("GET")
                .setOkHttpLo(new OkHttpLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        xwlb1s = new Gson().fromJson(jsonObject.optJSONArray("rows").toString(), new TypeToken<List<XWLB1>>() {
                        }.getType());
                        adapter = new XW1_Adapter(getActivity(), xwlb1s);
                        newList.setAdapter(adapter);
                        newList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = new Intent(requireContext(), NewDetailActivity.class);
                                intent.putExtra("xw", xwlb1s.get(position));
                                startActivity(intent);
                            }
                        });
                    }

                    @Override
                    public void onFailure(IOException e) {

                    }
                }).start();
    }

    private void initView() {
        ivFh = getView().findViewById(R.id.iv_fh);
        title1 = getView().findViewById(R.id.title1);
        tvGrzx = getView().findViewById(R.id.tv_grzx);
        mainFlipper = getView().findViewById(R.id.main_flipper);
        newTab = getView().findViewById(R.id.new_tab);
        newList = getView().findViewById(R.id.new_list2);
    }
}
