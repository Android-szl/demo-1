package com.example.gjtk_3.Main1_Acticity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gjtk_3.R;

public class fragment2 extends Fragment {
    private RelativeLayout ivYd;
    private TextView wlsz;
    private Button zhdl;
    private LinearLayout yd;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        ivYd.setBackgroundResource(R.drawable.ch5);
        zhdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(requireActivity(),M1_DengLu.class);
                startActivity(intent);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragment2, null);
    }

    private void initView() {
        ivYd = getView().findViewById(R.id.iv_yd);
        wlsz = getView().findViewById(R.id.wlsz);
        zhdl = getView().findViewById(R.id.zhdl);
        yd = getView().findViewById(R.id.yd);
    }
}