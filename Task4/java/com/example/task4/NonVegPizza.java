package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NonVegPizza extends AppCompatActivity {

    ListView listView;
    List<Model> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_veg_pizza);
        getSupportActionBar().hide();

        listView = findViewById(R.id.list1);
        list= new ArrayList<>();

        list.add(new Model(R.drawable.pepperbarbeque,"PEPPER BARBECUE CHICKEN","Rs. 250"));
        list.add(new Model(R.drawable.chickensausage,"CHICKEN SAUSAGE","Rs. 250"));
        list.add(new Model(R.drawable.goldendelight,"CHICKEN GOLDEN DELIGHT","Rs. 250"));

        list.add(new Model(R.drawable.supreme,"NON VEG SUPREME","Rs. 250"));
        list.add(new Model(R.drawable.dominator,"CHICKEN DOMINATOR","Rs. 250"));
        list.add(new Model(R.drawable.peperonion,"PEPPER BARBECUE & ONION","Rs. 250"));
        list.add(new Model(R.drawable.chunkychicken,"CHICKEN FIESTA","Rs. 250"));








        MyAdapter adapter= new MyAdapter(NonVegPizza.this,list);
        listView.setAdapter(adapter);
    }
}