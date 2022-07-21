package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Beverages extends AppCompatActivity {

    ListView listView;
    List<Model> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverages);
        getSupportActionBar().hide();

        listView = findViewById(R.id.list1);
        list= new ArrayList<>();

        list.add(new Model(R.drawable.jeera,"JEERA","Rs. 250"));
        list.add(new Model(R.drawable.limun,"LIMUN","Rs. 250"));
        list.add(new Model(R.drawable.orange,"ORANGE","Rs. 250"));

        list.add(new Model(R.drawable.malty,"MALTY","Rs. 250"));
        list.add(new Model(R.drawable.fresher,"FRESHER","Rs. 250"));
        list.add(new Model(R.drawable.green,"GREEN","Rs. 250"));
        list.add(new Model(R.drawable.cola,"COLA","Rs. 250"));
        list.add(new Model(R.drawable.changer,"CHANGER","Rs. 250"));
        list.add(new Model(R.drawable.herby,"HERBY","Rs. 250"));
        list.add(new Model(R.drawable.jeeraking,"JEERA KING","Rs. 250"));

        list.add(new Model(R.drawable.maltyteen,"MALTY","Rs. 250"));








        MyAdapter adapter= new MyAdapter(Beverages.this,list);
        listView.setAdapter(adapter);
    }
}