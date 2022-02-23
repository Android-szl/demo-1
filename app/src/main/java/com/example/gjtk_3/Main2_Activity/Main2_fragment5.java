package com.example.gjtk_3.Main2_Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gjtk_3.R;

public class Main2_fragment5 extends Fragment {
    private ImageView ivFh;
    private TextView title1;
    private TextView tvGrzx;
    private TextView tvYhm;
    private TextView grxx;
    private TextView xgyj;
    private TextView yjfk;
    private Button button;
    private ProgressDialog dialog;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        title1.setText("个人中心");

        GRXX();
        XGMM();
        YJFK();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main2_fragment5, null);
    }
    private void setDialog(){
        dialog=new ProgressDialog(requireContext());
        dialog.setTitle("正在加载");
        dialog.setMessage("等待中.....");
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
    public void GRXX(){
        grxx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDialog();
                Intent intent=new Intent(requireActivity(), Main2_Fragment5_GRZX.class);
                startActivity(intent);
//                Toast.makeText(requireContext(),"请检查网络设置",Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void XGMM(){
        xgyj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDialog();
                Intent intent=new Intent(requireActivity(), XiuGaiMiMa.class);
                startActivity(intent);

            }
        });
    }
    public void YJFK(){
        yjfk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDialog();
                Intent intent=new Intent(requireActivity(), Main2_Fragment5_YJFK.class);
                startActivity(intent);

            }
        });
    }
    private void initView() {
        button=getView().findViewById(R.id.button1);
        ivFh =getView(). findViewById(R.id.iv_fh);
        title1 =getView(). findViewById(R.id.title1);
        grxx =getView().findViewById(R.id.grxx);
        xgyj =getView().findViewById(R.id.xgyj);
        yjfk = getView().findViewById(R.id.yjfk);
    }
}
