package com.example.gallary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    GridView listView;
    List<Model> list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.hemal)));
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity2.this, R.color.hemal));
        listView=findViewById(R.id.list1);
        list1=new ArrayList<>();

        list1.add(new Model(R.drawable.lion,"Lion"));
        list1.add(new Model(R.drawable.tiger,"Tiger"));
        list1.add(new Model(R.drawable.elephant,"Elephant"));
        list1.add(new Model(R.drawable.giraffe,"Giraffe"));
        list1.add(new Model(R.drawable.wolf,"Wolf"));
        list1.add(new Model(R.drawable.monkey,"Monkey"));
        list1.add(new Model(R.drawable.snake,"Snake"));
        list1.add(new Model(R.drawable.turtle,"Turtle"));
        list1.add(new Model(R.drawable.bear,"Bear"));
        list1.add(new Model(R.drawable.deer,"Deer"));
        list1.add(new Model(R.drawable.cow,"Cow"));
        list1.add(new Model(R.drawable.dog,"Dog"));

        MyAdapter adapter = new MyAdapter(MainActivity2.this,list1);
        listView.setAdapter(adapter);

    }
}