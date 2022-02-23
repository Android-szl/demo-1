package com.example.gjtk_3;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.gjtk_3.Adapter.Main_fragment_adapter;
import com.example.gjtk_3.Main1_Acticity.fragment1;
import com.example.gjtk_3.Main1_Acticity.fragment2;
import com.example.gjtk_3.net.App;
import com.example.gjtk_3.net.OkHttpTo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 vpStart;
    private LinearLayout linear;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ImageView imageView;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setVP();
        System.out.println("sdfjsdlf");
    }

    public void setVP(){
        fragments.add(new fragment1(1));
        fragments.add(new fragment1(2));
        fragments.add(new fragment1(3));
        fragments.add(new fragment1(4));
        fragments.add(new fragment2());
        Main_fragment_adapter adapter=new Main_fragment_adapter(getSupportFragmentManager(),getLifecycle(),fragments);
        vpStart.setAdapter(adapter);
        vpStart.setCurrentItem(index);
        for (int i=0;i<fragments.size();i++){
            imageView=new ImageView(this);
            if (i==index){
                imageView.setImageResource(R.drawable.lb1);

            }else{
                imageView.setImageResource(R.drawable.lb2);
            }
            imageView.setLayoutParams(new ViewGroup.LayoutParams(70,70));
            linear.addView(imageView);
        }
        vpStart.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                for (int i = 0; i < fragments.size(); i++) {
                    imageView= (ImageView) linear.getChildAt(i);
                    if (i == position) {
                        imageView.setImageResource(R.drawable.lb1);
                    } else {
                        imageView.setImageResource(R.drawable.lb2);
                    }
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private static final String TAG = "Cannot invoke method length() on null object";
//    public void login(){
//
//        new OkHttpTo().setUrl("/prod-api/api/login")
//                .setType("POST")
//                .setJsonObject("username","gongjie")
//                .setJsonObject("password","123456")
//                .setOkHttpLo(jsonObject -> {
//                    if (jsonObject.optString("code").equals("200")){
//                        App.setToken(jsonObject.optString("token"));
//                        Log.d(TAG, "login: 123123123");
//                    }
//                }).start();
//    }

    private void initView() {
        vpStart = findViewById(R.id.vp_start);
        linear = findViewById(R.id.linear);
    }
}