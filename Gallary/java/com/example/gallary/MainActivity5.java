package com.example.gallary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {

    GridView gridView;
    List<Model> listfarm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.hemal)));
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity5.this, R.color.hemal));

        gridView = findViewById(R.id.listfarm);
        listfarm= new ArrayList<>();

        listfarm.add(new Model(R.drawable.f1,"Farm"));
        listfarm.add(new Model(R.drawable.f2,"Farm"));
        listfarm.add(new Model(R.drawable.f3,"Farm"));
        listfarm.add(new Model(R.drawable.f4,"Farm"));
        listfarm.add(new Model(R.drawable.f5,"Farm"));
        listfarm.add(new Model(R.drawable.f6,"Farm"));
        listfarm.add(new Model(R.drawable.f7,"Farm"));
        listfarm.add(new Model(R.drawable.f8,"Farm"));
        listfarm.add(new Model(R.drawable.f9,"Farm"));
        listfarm.add(new Model(R.drawable.f10,"Farm"));
        listfarm.add(new Model(R.drawable.f11,"Farm"));
        listfarm.add(new Model(R.drawable.f12,"Farm"));



        MyAdapter adapter = new MyAdapter(MainActivity5.this,listfarm);
        gridView.setAdapter(adapter);
    }
}