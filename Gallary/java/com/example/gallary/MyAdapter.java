package com.example.gallary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    Context con;
    List<Model> list;

    MyAdapter(Context con, List<Model> list)
    {
        this.con=con;
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

        LayoutInflater in = LayoutInflater.from(con);
        view=in.inflate(R.layout.design,viewGroup,false);

        ImageView img=view.findViewById(R.id.img1);
        TextView txt=view.findViewById(R.id.txt1);

        img.setImageResource(list.get(i).img);
        txt.setText(list.get(i).name);

        return view;
    }
}
