package com.example.gjtk_3.Main2_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.gjtk_3.Main1_Acticity.BusStop;
import com.example.gjtk_3.Main2_Activity.F1_Adapter.GridAdapter;
import com.example.gjtk_3.Main2_Activity.F1_Adapter.XW1_Adapter;
import com.example.gjtk_3.Main2_Activity.bean.Main2_fragment1_LBT;
import com.example.gjtk_3.Main2_Activity.bean.QBFW;
import com.example.gjtk_3.Main2_Activity.bean.TypeS;
import com.example.gjtk_3.Main2_Activity.bean.XWLB1;
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

public class Main2_fragment1 extends Fragment {
    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private ViewFlipper mainFlipper;
    private GridView gridView;
    private TabLayout newTab;
    private ListView listNew;
    private GridAdapter adapter;
    private ArrayList<QBFW> qbfws = new ArrayList<>();
    private ArrayList<XWLB1> xwlb1s = new ArrayList<>();
    private XW1_Adapter adapters;
    private ArrayList<Main2_fragment1_LBT> lbts;
    private ArrayList<TypeS> typeS;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        title1.setText("首页");
        LPT();
        QbFW();
        News();
        NewS(9);
        ivFh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().finish();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mian2_fragment1, null);
    }

    public void LPT() {
        new OkHttpTo()
                .setUrl("/prod-api/api/rotation/list?pageNum=1&pageSize=8&type=2")
                .setType("GET")
                .setOkHttpLo(new OkHttpLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        lbts = new Gson().fromJson(jsonObject.optJSONArray("rows").toString(), new TypeToken<List<Main2_fragment1_LBT>>() {
                        }.getType());
                        setLPT();
                    }

                    @Override
                    public void onFailure(IOException e) {

                    }
                }).start();
    }

    public void setLPT() {
        for (int i = 0; i < lbts.size(); i++) {
            ImageView imageView = new ImageView(requireContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            Glide.with(requireContext()).load("http://124.93.196.45:10001" + lbts.get(i).getAdvImg()).into(imageView);
            mainFlipper.addView(imageView);
        }
        mainFlipper.startFlipping();
    }

    public void QbFW() {
        new OkHttpTo()
                .setUrl("/prod-api/api/service/list")
                .setType("GET")
                .setOkHttpLo(new OkHttpLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        qbfws = new Gson().fromJson(jsonObject.optJSONArray("rows").toString(), new TypeToken<List<QBFW>>() {
                        }.getType());
                        if (qbfws.size() != 0) {
                            adapter = new GridAdapter(getActivity(), qbfws);
                            gridView.setAdapter(adapter);
                        }
                        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = null;

                                switch (position) {
                                    case 0:
                                        intent = new Intent(requireContext(), BusStop.class);
                                        startActivity(intent);
                                        break;
                                    case 1:
                                        intent = new Intent(requireContext(), CeShiJM.class);
                                        startActivity(intent);
                                        break;
                                    case 2:
                                        intent = new Intent(requireContext(),ZhiHuiBs.class);

                                        startActivity(intent);
                                        break;
                                    case 3:
                                        intent = new Intent(requireContext(), CeShiJM.class);
                                        startActivity(intent);
                                        break;
                                    case 4:
                                        intent = new Intent(requireContext(), CeShiJM.class);
                                        startActivity(intent);
                                        break;
                                    case 5:
                                        intent = new Intent(requireContext(), CeShiJM.class);
                                        startActivity(intent);
                                        break;
                                    case 6:
                                        intent = new Intent(requireContext(), CeShiJM.class);
                                        startActivity(intent);
                                        break;
                                    case 7:
                                        intent = new Intent(requireContext(), CeShiJM.class);
                                        startActivity(intent);
                                        break;
                                    case 8:
                                        intent = new Intent(requireContext(), CeShiJM.class);
                                        startActivity(intent);
                                        break;
                                    case 9:
                                        intent = new Intent(requireContext(), CeShiJM.class);
                                        startActivity(intent);
                                        break;

                                }
                            }
                        });
                    }

                    @Override
                    public void onFailure(IOException e) {

                    }
                }).start();
    }
    public void News() {
        new OkHttpTo()
                .setUrl("/prod-api/press/category/list")
                .setToken(App.getToken())
                .setType("GET")
                .setOkHttpLo(new OkHttpLo() {
//                    @Override
//                    public void onResponse(JSONObject jsonObject) {
//                        typeS = new Gson().fromJson(jsonObject.optJSONArray("data").toString(), new TypeToken<List<TypeS>>() {
//                        }.getType());
//                        for (int i = 0; i <= typeS.size(); i++) {
//                            newTab.addTab(newTab.newTab().setText(typeS.get(i).getName()));
//                        }
//                        newTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//                            @Override
//                            public void onTabSelected(TabLayout.Tab tab) {
//                                News(typeS.get(tab.getPosition()).getId());
//                            }
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        typeS = new Gson().fromJson(jsonObject.optJSONArray("data").toString(), new TypeToken<List<TypeS>>() {
                        }.getType());
                        for (int i = 0; i < typeS.size(); i++) {
                            newTab.addTab(newTab.newTab().setText(typeS.get(i).getName()));
                        }
                        newTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                            @Override
                            public void onTabSelected(TabLayout.Tab tab) {
                                NewS(typeS.get(tab.getPosition()).getId());
                            }

                            @Override
                            public void onTabUnselected(TabLayout.Tab tab) {
                            }

                            @Override
                            public void onTabReselected(TabLayout.Tab tab) {
                            }
                        });
                    }

                    @Override
                    public void onFailure(IOException e) {

                    }


                }).start();
    }
//    public void News() {
//        new OkHttpTo()
//                .setUrl("/prod-api/press/category/list")
//                .setToken(App.getToken())
//                .setType("GET")
//                .setOkHttpLo(new OkHttpLo() {
//
//
//                            @Override
//                            public void onTabUnselected(TabLayout.Tab tab) {
//
//                            }
//
//                            @Override
//                            public void onTabReselected(TabLayout.Tab tab) {
//
//                            }
//                        });
//                    }
//
//                    @Override
//                    public void onFailure(IOException e) {
//
//                    }
//                }).start();
//    }

    public void NewS(int id) {
        new OkHttpTo()
                .setUrl("/prod-api/press/press/list?type=" + id)
                .setType("GET")
                .setOkHttpLo(new OkHttpLo() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        xwlb1s = new Gson().fromJson(jsonObject.optJSONArray("rows").toString(), new TypeToken<List<XWLB1>>() {
                        }.getType());
                        adapters = new XW1_Adapter(getActivity(), xwlb1s);
                        listNew.setAdapter(adapters);
                        listNew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = new Intent(requireContext(), NewDetailActivity.class);
//                                intent.putExtra("xw",xwlb1s.get(position));
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
        gridView = getView().findViewById(R.id.grid_view);
        newTab = getView().findViewById(R.id.new_tab);
        listNew = getView().findViewById(R.id.list_new);
    }
}
