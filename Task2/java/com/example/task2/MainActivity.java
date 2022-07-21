package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    List<Model> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.list1);
        list= new ArrayList<>();

        list.add(new Model(R.drawable.a1,"HP","30000"));
        list.add(new Model(R.drawable.a2,"Lenovo","40000"));
        list.add(new Model(R.drawable.a1,"HP","30000"));
        list.add(new Model(R.drawable.a2,"Lenovo","40000"));
        list.add(new Model(R.drawable.a1,"HP","30000"));
        list.add(new Model(R.drawable.a2,"Lenovo","40000"));
        list.add(new Model(R.drawable.a1,"HP","30000"));
        list.add(new Model(R.drawable.a2,"Lenovo","40000"));
        list.add(new Model(R.drawable.a1,"HP","50000"));


        MyAdapter adapter = new MyAdapter(MainActivity.this,list);
        listView.setAdapter(adapter);






    }
}