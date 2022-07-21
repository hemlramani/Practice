package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PizzaMania extends AppCompatActivity {

    ListView listView;
    List<Model> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_mania);
        getSupportActionBar().hide();

        listView = findViewById(R.id.list1);
        list= new ArrayList<>();

        list.add(new Model(R.drawable.pizzamaniatomato,"TOMATO","Rs. 250"));
        list.add(new Model(R.drawable.pizzamaniatomato,"VEG LOADED","Rs. 250"));
        list.add(new Model(R.drawable.primecheesy,"CHEESY","Rs. 250"));

        list.add(new Model(R.drawable.capsicumveg,"CAPSICUM","Rs. 250"));
        list.add(new Model(R.drawable.onionveg,"ONION","Rs. 250"));
        list.add(new Model(R.drawable.goldencornveg,"GOLDEN CORN","Rs. 250"));
        list.add(new Model(R.drawable.paneerspecial,"PANEER & ONION","Rs. 250"));

        list.add(new Model(R.drawable.cheeseandtomato,"CHEESE N TOMATO","Rs. 250"));






        MyAdapter adapter= new MyAdapter(PizzaMania.this,list);
        listView.setAdapter(adapter);
    }
}