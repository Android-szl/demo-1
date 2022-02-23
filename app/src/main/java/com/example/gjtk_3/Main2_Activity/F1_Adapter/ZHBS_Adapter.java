package com.example.gjtk_3.Main2_Activity.F1_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gjtk_3.Main2_Activity.bean.CD;
import com.example.gjtk_3.R;

import java.util.ArrayList;

public class ZHBS_Adapter extends BaseAdapter {
    private ArrayList<CD> cds;
    private LayoutInflater inflater;
    public ZHBS_Adapter(Context context, ArrayList<CD>cds){
        inflater=LayoutInflater.from(context);
        this.cds=cds;
    }
    @Override
    public int getCount() {
        return cds.size();
    }

    @Override
    public Object getItem(int position) {
        return cds.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if (view==null){
            viewHolder=new ViewHolder();
            view=inflater.inflate(R.layout.listview,null);
            viewHolder.bus_id=view.findViewById(R.id.bus_id);
            viewHolder.bus_line=view.findViewById(R.id.bus_line);
            viewHolder.jg=view.findViewById(R.id.jg);
            viewHolder.lc=view.findViewById(R.id.lc);
            viewHolder.tm_z=view.findViewById(R.id.tm_z);
            viewHolder.tm_w=view.findViewById(R.id.tm_w);
            viewHolder.image=view.findViewById(R.id.image);
            viewHolder.dianji=view.findViewById(R.id.dianji);
            view.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)view.getTag();
        }
        Glide.with(parent.getContext()).load("http://124.93.196.45:10001" + cds.get(i));
        viewHolder.bus_id.setText(cds.get(i).getName());
        viewHolder.bus_line.setText(cds.get(i).getFirst()+"----"+cds.get(i).getEnd());
        viewHolder.jg.setText("票价："+cds.get(i).getPrice()+"元");
        viewHolder.lc.setText("里程："+cds.get(i).getMileage()+"公里");
        viewHolder.tm_z.setText(cds.get(i).getCreateTime());
        viewHolder.tm_w.setText(cds.get(i).getUpdateTime());
        return view;
    }
    public class ViewHolder{
        private TextView bus_id;
        private TextView bus_line;
        private TextView jg;
        private TextView lc;
        private TextView tm_z;
        private TextView tm_w;
        private ImageView image;
        private LinearLayout dianji;
    }
}
