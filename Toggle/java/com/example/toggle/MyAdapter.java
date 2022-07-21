package com.example.toggle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    Context context;
    List<Model>list;
    MyAdapter(Context context,List<Model> list)
    {
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater in = LayoutInflater.from(context);
        view=in.inflate(R.layout.design,viewGroup,false);

        ImageView imageView1=view.findViewById(R.id.img1);
        TextView textView1=view.findViewById(R.id.txt1);
        TextView textView2=view.findViewById(R.id.txt2);

        imageView1.setImageResource(list.get(i).image);
        textView1.setText(list.get(i).name);
        textView2.setText(list.get(i).price);

        return view;
    }
}
