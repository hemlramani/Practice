package com.example.toggle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;
    List<Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView=findViewById(R.id.list1);
        list=new ArrayList<>();

        list.add(new Model(R.drawable.a1,"HP Laptop","50000"));
        list.add(new Model(R.drawable.a2,"Lenovo","600000"));
        list.add(new Model(R.drawable.a1,"HP Laptop","50000"));
        list.add(new Model(R.drawable.a2,"Lenovo","600000"));
        list.add(new Model(R.drawable.a1,"HP Laptop","50000"));
        list.add(new Model(R.drawable.a2,"Lenovo","600000"));
        list.add(new Model(R.drawable.a1,"HP Laptop","50000"));
        list.add(new Model(R.drawable.a2,"Lenovo","600000"));


        MyAdapter myAdapter = new MyAdapter(MainActivity2.this,list);
        listView.setAdapter(myAdapter);
    }
}