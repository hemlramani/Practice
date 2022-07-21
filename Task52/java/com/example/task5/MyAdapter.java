package com.example.task5;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {

    Context context;
    List<Model> list;

    public MyAdapter(Context context, List<Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class MyView extends RecyclerView.ViewHolder {

        ImageView img1;
        TextView textView1,textView2;

        public MyView(@NonNull View itemView) {
            super(itemView);

            img1=itemView.findViewById(R.id.img1);
            textView1=itemView.findViewById(R.id.txt1);
            textView2=itemView.findViewById(R.id.txt2);
        }
    }
}
