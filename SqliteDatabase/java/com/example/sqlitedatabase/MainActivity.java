package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    EditText txt1,txt2;
    Button btn1;
    DbHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        btn1=findViewById(R.id.btn1);
        helper=new DbHelper(getApplicationContext());

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = txt1.getText().toString();
                String pass = txt2.getText().toString();

                Model m = new Model();
                m.setName(name);
                m.setPass(pass);
                long id = helper.savedata(m);


                Toast.makeText(MainActivity.this, ""+id, Toast.LENGTH_SHORT).show();


            }
        });
    }
}