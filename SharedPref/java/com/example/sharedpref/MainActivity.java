package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText edt1,edt2;
    Button btn1;
    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edt1=findViewById(R.id.txt1);
        edt2=findViewById(R.id.txt2);
        btn1=findViewById(R.id.btn1);
        sharedPreferences=getSharedPreferences("user_session", Context.MODE_PRIVATE);

        if(sharedPreferences.getBoolean("user_session",false) && !sharedPreferences.getString("Name","").isEmpty())
        {
            Intent i = new Intent(MainActivity.this,Welcome.class);
            startActivity(i);
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = edt1.getText().toString();
                String pass = edt2.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Name",name);
                editor.putString("Pass",pass);
                editor.putBoolean("user_session",true);
                editor.apply();
                editor.commit();

                Intent i = new Intent(MainActivity.this,Welcome.class);
                startActivity(i);

            }
        });

    }


}