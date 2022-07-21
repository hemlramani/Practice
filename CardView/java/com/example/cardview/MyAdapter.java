package com.example.cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myview> {

    Context context;
    List<Model> list;

    public MyAdapter(Context context, List<Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.design,parent,false);

        return new Myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myview holder, int position) {

        holder.imageView.setImageResource(list.get(position).img);
        holder.txt1.setText(list.get(position).nm);
        holder.txt2.setText(list.get(position).prc);

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Myview extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView txt1,txt2;

        public Myview(@NonNull View itemView) {

            super(itemView);

            imageView=itemView.findViewById(R.id.img1);
            txt1=itemView.findViewById(R.id.txt1);
            txt2=itemView.findViewById(R.id.txt2);
        }
    }
}
