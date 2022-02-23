package com.example.gjtk_3.Main2_Activity.F1_Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gjtk_3.Main2_Activity.bean.XWLB1;
import com.example.gjtk_3.NewDetailActivity;
import com.example.gjtk_3.R;

import java.util.ArrayList;

public class XW1_Adapter extends BaseAdapter {
    public interface Click {
        void Clicks(int position, String name);
    }

    private ArrayList<XWLB1> xwlb1s;
    private LayoutInflater inflater;
    private Context context;
    private Click click;

    public XW1_Adapter(Context context, ArrayList<XWLB1> xwlb1s) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.xwlb1s = xwlb1s;
    }

    public void setClick(Click click) {
        this.click = click;
    }

    @Override
    public int getCount() {
        return xwlb1s.size();
    }

    @Override
    public Object getItem(int position) {
        return xwlb1s.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.xw_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


//        viewHolder.tv_nr.setText(xwlb1s.get(position).getContent().substring(0, 50) + "......");
        viewHolder.title.setText(xwlb1s.get(position).getTitle().substring(0, 9) + "...");
//        viewHolder.tv_nr.setText(Html.fromHtml(xwlb1s.get(position).getContent()));

//        switch (position) {
//            case 1:
//                viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                    }
//                });
//                break;
//        }
        Glide.with(context)
                .load("http://124.93.196.45:10001" + xwlb1s.get(position).getCover())
                .into(viewHolder.iv);


//        viewHolder.linearLayout.setOnClickListener(v -> {
///**  viewHolder.tv_nr.setText(Html.fromHtml(xwlb1s.get(0).getContent()));  */
//            Intent intent = new Intent(parent.getContext(), NewDetailActivity.class);
//            intent.putExtra("xw", xwlb1s.get(position));
//            parent.getContext().startActivity(intent);
//        });


        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(), NewDetailActivity.class);
                intent.putExtra("xw", xwlb1s.get(position));
                parent.getContext().startActivity(intent);
            }
        });
        return convertView;
    }

    static class ViewHolder {
        LinearLayout linearLayout;
        TextView title;
        ImageView iv;
        TextView tv_nr;

        public ViewHolder(View view) {
            linearLayout = view.findViewById(R.id.linearlayout);
            tv_nr = view.findViewById(R.id.tv_nr);
            title = view.findViewById(R.id.tv_title);
            iv = view.findViewById(R.id.iv);
        }

    }
}
