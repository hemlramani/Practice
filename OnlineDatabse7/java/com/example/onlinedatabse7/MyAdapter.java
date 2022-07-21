package com.example.onlinedatabse7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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

        TextView name,email,adress,gender,mobile,home,office;

        name = view.findViewById(R.id.name);
        email = view.findViewById(R.id.email);
        adress = view.findViewById(R.id.adress);
        gender = view.findViewById(R.id.gender);
        mobile = view.findViewById(R.id.mobile);
        home = view.findViewById(R.id.home);
        office = view.findViewById(R.id.office);

        name.setText(list.get(i).name);
        email.setText(list.get(i).email);
        adress.setText(list.get(i).adress);
        gender.setText(list.get(i).gender);
        mobile.setText(list.get(i).mobile);
        home.setText(list.get(i).home);
        office.setText(list.get(i).office);


        return view;
    }
}
