package com.example.onlinedatabase6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends BaseAdapter {


    Context context;
    List<Model> list;

    public MyAdapter(Context context, List<Model> list) {
        this.context = context;
        this.list = list;
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

        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.design,viewGroup,false);

        TextView txt1 = view.findViewById(R.id.txt1);
        ImageView img  = view.findViewById(R.id.img1);

       txt1.setText(list.get(i).name);

        Picasso.get().load(list.get(i).imageurl).into(img);

        return view;
    }
}
