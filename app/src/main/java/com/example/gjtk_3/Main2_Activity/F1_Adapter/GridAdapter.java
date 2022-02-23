package com.example.gjtk_3.Main2_Activity.F1_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gjtk_3.Main2_Activity.bean.QBFW;
import com.example.gjtk_3.R;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    public interface Click {
        void Clicks(int position, String name);
    }

    private ArrayList<QBFW> qbfws;
    private Context context;
    private LayoutInflater inflater;
    private Click click;

    public void setOnclick(Click click) {
        this.click = click;
    }

    public GridAdapter(Context context, ArrayList<QBFW> qbfws) {
        this.context = context;
        this.qbfws = qbfws;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return qbfws.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.lay_grid, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (position == 9) {
            viewHolder.iv_fwt.setImageResource(R.drawable.more);
            viewHolder.tv_fwm.setText("更多服务");
        } else {
            Glide.with(parent.getContext()).load("http://124.93.196.45:10001" + qbfws.get(position).getImgUrl()).into(viewHolder.iv_fwt);
            viewHolder.tv_fwm.setText(qbfws.get(position).getServiceName());
        }
        return convertView;
    }

    public class ViewHolder {
        TextView tv_fwm;
        ImageView iv_fwt;

        public ViewHolder(View convertView) {
            tv_fwm = convertView.findViewById(R.id.tv_fwma);
            iv_fwt = convertView.findViewById(R.id.iv_fwta);
        }
    }
}
