package com.example.hemal275;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list1;
    List<String> list;
    SearchView search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1=findViewById(R.id.list1);
        list = new ArrayList<>();
        search=findViewById(R.id.src1);

        list.add("Android");
        list.add("Java");
        list.add("Kotlin");
        list.add("Android");
        list.add("Java");
        list.add("Kotlin");
        list.add("Android");
        list.add("Java");
        list.add("Kotlin");
        list.add("Android");
        list.add("Java");
        list.add("Kotlin");
        list.add("Android");
        list.add("Java");
        list.add("Kotlin");


        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,list);
        list1.setAdapter(adapter);

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                return false;
            }
        });

    }
}