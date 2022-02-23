package com.example.gjtk_3.Main2_Activity.F1_Adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gjtk_3.Main2_Activity.bean.JKsj;
import com.example.gjtk_3.R;

import java.util.ArrayList;

public class BusStopAdapter extends BaseAdapter {
    private ArrayList<JKsj> jKsjs;
    private Context context;
    private LayoutInflater inflater;


    public BusStopAdapter(Context context, ArrayList<JKsj> jKsjs) {
        this.context = context;
        this.jKsjs = jKsjs;
        inflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return jKsjs.size();
    }

    @Override
    public Object getItem(int position) {
        return jKsjs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.busstop, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Glide.with(parent.getContext()).load("http://124.93.196.45:10001" + jKsjs.get(position));
        viewHolder.Iamge.setText(String.valueOf(jKsjs.get(position).getParkName()));
        viewHolder.hd.setText(String.valueOf(jKsjs.get(position).getAddress()));
        viewHolder.huangd.setText(String.valueOf(jKsjs.get(position).getVacancy()));
        viewHolder.ld.setText(String.valueOf(jKsjs.get(position).getRates()+"元/每小时"));
        viewHolder.ld1.setText(String.valueOf((jKsjs.get(position).getPriceCaps()+"/每天")));

        return convertView;

//        Log.d("TAG", "getView: "+jKsjs.get(position).getImgUrl());
    }

    public class ViewHolder {
        private TextView Iamge;
        private TextView hd;
        private TextView huangd;
        private TextView ld;
        private TextView ld1;
        private LinearLayout linearlayout;

        public ViewHolder(View view) {
            linearlayout=view.findViewById(R.id.linearlayout);
            Iamge = view.findViewById(R.id.Iamge);
            hd = view.findViewById(R.id.hd);
            huangd = view.findViewById(R.id.huangd);
            ld = view.findViewById(R.id.ld);
            ld1 = view.findViewById(R.id.ld1);
        }
    }
}
