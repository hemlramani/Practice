package com.example.hemal275;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity2 extends AppCompatActivity {

    AutoCompleteTextView txt1;
    String name[]= {"Android","Java","Ios","Flutter","React Native"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt1=findViewById(R.id.txt1);

        ArrayAdapter adapter = new ArrayAdapter(MainActivity2.this, android.R.layout.select_dialog_item,name);
        txt1.setThreshold(1);
        txt1.setAdapter(adapter);


    }
}