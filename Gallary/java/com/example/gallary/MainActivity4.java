package com.example.gallary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {

    GridView gridView;
    List<Model> listnature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.hemal)));
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity4.this, R.color.hemal));

        gridView= findViewById(R.id.listnature);
        listnature=new ArrayList<>();

        listnature.add(new Model(R.drawable.n1,"Nature"));
        listnature.add(new Model(R.drawable.n2,"Nature"));
        listnature.add(new Model(R.drawable.n3,"Nature"));
        listnature.add(new Model(R.drawable.n4,"Nature"));
        listnature.add(new Model(R.drawable.n5,"Nature"));
        listnature.add(new Model(R.drawable.n6,"Nature"));
        listnature.add(new Model(R.drawable.n7,"Nature"));
        listnature.add(new Model(R.drawable.n8,"Nature"));
        listnature.add(new Model(R.drawable.n9,"Nature"));
        listnature.add(new Model(R.drawable.n10,"Nature"));
        listnature.add(new Model(R.drawable.n11,"Nature"));
        listnature.add(new Model(R.drawable.n12,"Nature"));

        MyAdapter adapter = new MyAdapter(MainActivity4.this,listnature);
        gridView.setAdapter(adapter);
    }
}