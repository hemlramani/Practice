package com.example.task4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    Context context;
    List<Model> list;

    MyAdapter(Context context, List<Model> list)
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

        LayoutInflater inflater= LayoutInflater.from(context);
        view=inflater.inflate(R.layout.design,viewGroup,false);

        ImageView imageView =view.findViewById(R.id.img1);
        TextView txt1=view.findViewById(R.id.txt1);
        TextView txt2=view.findViewById(R.id.txt2);

        imageView.setImageResource(list.get(i).img);
        txt1.setText(list.get(i).nm);
        txt2.setText(list.get(i).prc);




        return view;
    }
}
