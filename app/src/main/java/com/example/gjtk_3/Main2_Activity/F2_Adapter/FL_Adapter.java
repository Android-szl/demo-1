package com.example.gjtk_3.Main2_Activity.F2_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gjtk_3.Main2_Activity.F1_Adapter.GridAdapter;
import com.example.gjtk_3.R;

import java.util.ArrayList;

public class FL_Adapter extends BaseAdapter {
    private LayoutInflater inflater;
    private GridAdapter.Click click;
    private ArrayList<String> fwm;
    public FL_Adapter(Context context, ArrayList<String> fwm)
    {
        this.fwm=fwm;
        inflater=LayoutInflater.from(context);
    }
    public void setClick(GridAdapter.Click click)
    {
        this.click=click;
    }
    @Override
    public int getCount() {
        return fwm.size();
    }

    @Override
    public Object getItem(int position) {
        return fwm.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null)
        {
            viewHolder=new ViewHolder();
            convertView=inflater.inflate(R.layout.lay_fl,null);
            viewHolder.textView=convertView.findViewById(R.id.tv_fl);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(fwm.get(position));
        viewHolder.textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                click.Clicks(position,fwm.get(position));
            }
        });
        return convertView;
    }

    public class ViewHolder
    {
        TextView textView;
    }
}
