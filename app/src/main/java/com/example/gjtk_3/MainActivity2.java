package com.example.gjtk_3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.gjtk_3.Main2_Activity.F1_Adapter.SPQ;
import com.example.gjtk_3.Main2_Activity.Main2_fragment1;
import com.example.gjtk_3.Main2_Activity.Main2_fragment2;
import com.example.gjtk_3.Main2_Activity.Main2_fragment3;
import com.example.gjtk_3.Main2_Activity.Main2_fragment4;
import com.example.gjtk_3.Main2_Activity.Main2_fragment5;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private ViewPager2 viewpager;
    private ImageView iv1;
    private TextView tv1;
    private ImageView iv2;
    private TextView tv2;
    private ImageView iv3;
    private TextView tv3;
    private ImageView iv4;
    private TextView tv4;
    private ImageView iv5;
    private TextView tv5;
    private ArrayList<Fragment>fragments=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        fragments.add(new Main2_fragment1());
        fragments.add(new Main2_fragment2());
        fragments.add(new Main2_fragment3());
        fragments.add(new Main2_fragment4());
        fragments.add(new Main2_fragment5());
        SPQ adapter = new SPQ(getSupportFragmentManager(), getLifecycle(), fragments);
        viewpager.setAdapter(adapter);
        viewpager.setOffscreenPageLimit(5);
        viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        iv1.setImageResource(R.mipmap.sy2);
                        tv1.setTextColor(Color.parseColor("#827B7B"));
                        iv2.setImageResource(R.mipmap.gd1);
                        tv2.setTextColor(Color.parseColor("#ffffff"));
                        iv3.setImageResource(R.mipmap.dj);
                        tv3.setTextColor(Color.parseColor("#ffffff"));
                        iv4.setImageResource(R.mipmap.xw1);
                        tv4.setTextColor(Color.parseColor("#ffffff"));
                        iv5.setImageResource(R.mipmap.gr1);
                        tv5.setTextColor(Color.parseColor("#ffffff"));
                        break;
                    case 1:
                        iv1.setImageResource(R.mipmap.sy1);
                        tv1.setTextColor(Color.parseColor("#ffffff"));
                        iv2.setImageResource(R.mipmap.gd2);
                        tv2.setTextColor(Color.parseColor("#827B7B"));
                        iv3.setImageResource(R.mipmap.dj);
                        tv3.setTextColor(Color.parseColor("#ffffff"));
                        iv4.setImageResource(R.mipmap.xw1);
                        tv4.setTextColor(Color.parseColor("#ffffff"));
                        iv5.setImageResource(R.mipmap.gr1);
                        tv5.setTextColor(Color.parseColor("#ffffff"));
                        break;
                    case 2:
                        iv1.setImageResource(R.mipmap.sy1);
                        tv1.setTextColor(Color.parseColor("#ffffff"));
                        iv2.setImageResource(R.mipmap.gd1);
                        tv2.setTextColor(Color.parseColor("#ffffff"));
                        iv3.setImageResource(R.mipmap.dj2);
                        tv3.setTextColor(Color.parseColor("#827B7B"));
                        iv4.setImageResource(R.mipmap.xw1);
                        tv4.setTextColor(Color.parseColor("#ffffff"));
                        iv5.setImageResource(R.mipmap.gr1);
                        tv5.setTextColor(Color.parseColor("#ffffff"));
                        break;
                    case 3:
                        iv1.setImageResource(R.mipmap.sy1);
                        tv1.setTextColor(Color.parseColor("#ffffff"));
                        iv2.setImageResource(R.mipmap.gd1);
                        tv2.setTextColor(Color.parseColor("#ffffff"));
                        iv3.setImageResource(R.mipmap.dj);
                        tv3.setTextColor(Color.parseColor("#ffffff"));
                        iv4.setImageResource(R.mipmap.xw2);
                        tv4.setTextColor(Color.parseColor("#827B7B"));
                        iv5.setImageResource(R.mipmap.gr1);
                        tv5.setTextColor(Color.parseColor("#ffffff"));
                        break;
                    case 4:
                        iv1.setImageResource(R.mipmap.sy1);
                        tv1.setTextColor(Color.parseColor("#ffffff"));
                        iv2.setImageResource(R.mipmap.gd1);
                        tv2.setTextColor(Color.parseColor("#ffffff"));
                        iv3.setImageResource(R.mipmap.dj);
                        tv3.setTextColor(Color.parseColor("#ffffff"));
                        iv4.setImageResource(R.mipmap.xw1);
                        tv4.setTextColor(Color.parseColor("#ffffff"));
                        iv5.setImageResource(R.mipmap.gr2);
                        tv5.setTextColor(Color.parseColor("#827B7B"));
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

        public void click(View view){
            switch (view.getId()) {
                case R.id.iv_1:
                    iv1.setImageResource(R.mipmap.sy2);
                    tv1.setTextColor(Color.parseColor("#827B7B"));
                    iv2.setImageResource(R.mipmap.gd1);
                    tv2.setTextColor(Color.parseColor("#ffffff"));
                    iv3.setImageResource(R.mipmap.dj);
                    tv3.setTextColor(Color.parseColor("#ffffff"));
                    iv4.setImageResource(R.mipmap.xw1);
                    tv4.setTextColor(Color.parseColor("#ffffff"));
                    iv5.setImageResource(R.mipmap.gr1);
                    tv5.setTextColor(Color.parseColor("#ffffff"));
                    viewpager.setCurrentItem(0);
                    break;
                case R.id.iv_2:
                    iv1.setImageResource(R.mipmap.sy1);
                    tv1.setTextColor(Color.parseColor("#ffffff"));
                    iv2.setImageResource(R.mipmap.gd2);
                    tv2.setTextColor(Color.parseColor("#827B7B"));
                    iv3.setImageResource(R.mipmap.dj);
                    tv3.setTextColor(Color.parseColor("#ffffff"));
                    iv4.setImageResource(R.mipmap.xw1);
                    tv4.setTextColor(Color.parseColor("#ffffff"));
                    iv5.setImageResource(R.mipmap.gr1);
                    tv5.setTextColor(Color.parseColor("#ffffff"));
                    viewpager.setCurrentItem(1);
                    break;
                case R.id.iv_3:
                    iv1.setImageResource(R.mipmap.sy1);
                    tv1.setTextColor(Color.parseColor("#ffffff"));
                    iv2.setImageResource(R.mipmap.gd1);
                    tv2.setTextColor(Color.parseColor("#ffffff"));
                    iv3.setImageResource(R.mipmap.dj2);
                    tv3.setTextColor(Color.parseColor("#827B7B"));
                    iv4.setImageResource(R.mipmap.xw1);
                    tv4.setTextColor(Color.parseColor("#ffffff"));
                    iv5.setImageResource(R.mipmap.gr1);
                    tv5.setTextColor(Color.parseColor("#ffffff"));
                    viewpager.setCurrentItem(2);
                    break;
                case R.id.iv_4:
                    iv1.setImageResource(R.mipmap.sy1);
                    tv1.setTextColor(Color.parseColor("#ffffff"));
                    iv2.setImageResource(R.mipmap.gd1);
                    tv2.setTextColor(Color.parseColor("#ffffff"));
                    iv3.setImageResource(R.mipmap.dj);
                    tv3.setTextColor(Color.parseColor("#ffffff"));
                    iv4.setImageResource(R.mipmap.xw2);
                    tv4.setTextColor(Color.parseColor("#827B7B"));
                    iv5.setImageResource(R.mipmap.gr1);
                    tv5.setTextColor(Color.parseColor("#ffffff"));
                    viewpager.setCurrentItem(3);
                    break;
                case R.id.iv_5:
                    iv1.setImageResource(R.mipmap.sy1);
                    tv1.setTextColor(Color.parseColor("#ffffff"));
                    iv2.setImageResource(R.mipmap.gd1);
                    tv2.setTextColor(Color.parseColor("#ffffff"));
                    iv3.setImageResource(R.mipmap.dj);
                    tv3.setTextColor(Color.parseColor("#ffffff"));
                    iv4.setImageResource(R.mipmap.xw1);
                    tv4.setTextColor(Color.parseColor("#ffffff"));
                    iv5.setImageResource(R.mipmap.gr2);
                    tv5.setTextColor(Color.parseColor("#827B7B"));
                    viewpager.setCurrentItem(4);
                    break;
            }
            }


    private void initView() {
        viewpager = findViewById(R.id.viewpager);
        iv1 = findViewById(R.id.iv_1);
        tv1 = findViewById(R.id.tv_1);
        iv2 = findViewById(R.id.iv_2);
        tv2 = findViewById(R.id.tv_2);
        iv3 = findViewById(R.id.iv_3);
        tv3 = findViewById(R.id.tv_3);
        iv4 = findViewById(R.id.iv_4);
        tv4 = findViewById(R.id.tv_4);
        iv5 = findViewById(R.id.iv_5);
        tv5 = findViewById(R.id.tv_5);
    }
}