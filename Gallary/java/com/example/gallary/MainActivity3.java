package com.example.gallary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    GridView listview;
    List<Model> list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.hemal)));
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity3.this, R.color.hemal));

        listview= findViewById(R.id.list2);
        list1=new ArrayList<>();

        list1.add(new Model(R.drawable.peacock,"Peacock"));
        list1.add(new Model(R.drawable.dove,"Dove"));
        list1.add(new Model(R.drawable.owl,"Owl"));
        list1.add(new Model(R.drawable.sparrow,"Sparrow"));
        list1.add(new Model(R.drawable.animal,"Cock"));
        list1.add(new Model(R.drawable.vulture,"Vulture"));
        list1.add(new Model(R.drawable.eagle,"Eagle"));
        list1.add(new Model(R.drawable.flamingo,"Flamingo"));
        list1.add(new Model(R.drawable.duck,"Duck"));
        list1.add(new Model(R.drawable.bulbul,"Bulbul"));
        list1.add(new Model(R.drawable.hummingbird,"Humming Bird"));
        list1.add(new Model(R.drawable.swan,"Swan"));

        MyAdapter adapter = new MyAdapter(MainActivity3.this,list1);
        listview.setAdapter(adapter);



    }
}