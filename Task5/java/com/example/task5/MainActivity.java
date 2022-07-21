package com.example.task5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Model> list;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.black));


        recyclerView = findViewById(R.id.recycle);
        list = new ArrayList<>();
        toolbar=findViewById(R.id.tool);



        RecyclerView.LayoutManager lm = new GridLayoutManager(MainActivity.this,2);
        recyclerView.setLayoutManager(lm);

        list.add(new Model(R.drawable.arjitsingh,"Arjit Sinh"));
        list.add(new Model(R.drawable.kk,"K K"));
        list.add(new Model(R.drawable.arrehman,"A. R. Rehman"));
        list.add(new Model(R.drawable.honey,"Honey Singh"));
        list.add(new Model(R.drawable.sidhu,"Sidhu Moosewala"));
        list.add(new Model(R.drawable.guru,"Guru Randhawa"));



        MyAdapter adapter = new MyAdapter(MainActivity.this,list);
        recyclerView.setAdapter(adapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "hii", Toast.LENGTH_SHORT).show();
            }
        });

    }
}