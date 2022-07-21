package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycle);
        list= new ArrayList<>();

        RecyclerView.LayoutManager lm = new GridLayoutManager(MainActivity.this,2);
        recyclerView.setLayoutManager(lm);

        list.add(new Model(R.drawable.jeera,"Jeera","10"));
        list.add(new Model(R.drawable.limun,"Limun","10"));
        list.add(new Model(R.drawable.malty,"Malty","10"));
        list.add(new Model(R.drawable.orange,"Orange","10"));
        list.add(new Model(R.drawable.jeera,"Jeera","10"));
        list.add(new Model(R.drawable.limun,"Limun","10"));
        list.add(new Model(R.drawable.malty,"Malty","10"));
        list.add(new Model(R.drawable.orange,"Orange","10"));
        list.add(new Model(R.drawable.jeera,"Jeera","10"));
        list.add(new Model(R.drawable.limun,"Limun","10"));
        list.add(new Model(R.drawable.malty,"Malty","10"));
        list.add(new Model(R.drawable.orange,"Orange","10"));

        MyAdapter adapter = new MyAdapter(MainActivity.this,list);
        recyclerView.setAdapter(adapter);
    }
}