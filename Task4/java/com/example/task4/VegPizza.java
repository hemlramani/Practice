package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class VegPizza extends AppCompatActivity {

    ListView listView;
    List<Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg_pizza);
        getSupportActionBar().hide();

        listView = findViewById(R.id.list1);
        list= new ArrayList<>();

        list.add(new Model(R.drawable.margherit,"MARGHERITA","Rs. 250"));
        list.add(new Model(R.drawable.dblchesmargherita,"DOUBLE CHEESE","Rs. 250"));
        list.add(new Model(R.drawable.farmhouse,"FARM HOUSE","Rs. 250"));

        list.add(new Model(R.drawable.peppypaneer,"PEPPY PANEER","Rs. 250"));
        list.add(new Model(R.drawable.mexicangreenwave,"MEXICAN GREEN WAVE","Rs. 250"));
        list.add(new Model(R.drawable.deluxeveggie,"DELUXE VEGGIE","Rs. 250"));
        list.add(new Model(R.drawable.vegextravaganz,"VEG EXTRAVAGANZA","Rs. 250"));
        list.add(new Model(R.drawable.corncheese,"CHEESE N CORN","Rs. 250"));

        list.add(new Model(R.drawable.paneermakhni,"PANEER MAKHANI","Rs. 250"));







        MyAdapter adapter= new MyAdapter(VegPizza.this,list);
        listView.setAdapter(adapter);
    }
}