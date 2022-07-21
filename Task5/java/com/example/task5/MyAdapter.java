package com.example.task5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        View view = inflater.inflate(R.layout.design,parent,false);

        return new Myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myview holder, int position) {

        holder.imageView.setImageResource(list.get(position).img);
        holder.txt1.setText(list.get(position).name);

    }



    @Override
    public int getItemCount() {
        return list.size();
    }




    public class  Myview extends RecyclerView.ViewHolder  implements View.OnClickListener{

        ImageView imageView;
        TextView txt1;
        public Myview(@NonNull View itemView) {



            super(itemView);
            imageView=itemView.findViewById(R.id.img1);
            txt1=itemView.findViewById(R.id.txt1);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();

            switch (position)
            {
                case 0:
                    Toast.makeText(context, "Arijit Singh", Toast.LENGTH_SHORT).show();
                    break;

                case 1:
                    Toast.makeText(context, "K K", Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    }
}
