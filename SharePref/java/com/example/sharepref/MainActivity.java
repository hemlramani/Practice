package com.example.sharepref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    EditText txt1,txt2;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.btn1);
        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        sharedPreferences=getSharedPreferences("user_session", Context.MODE_PRIVATE);

        //if(sharedPreferences.getBoolean("user_session",false) && !sharedPreferences.getString("Name","").isEmpty())

        boolean hemal = sharedPreferences.getBoolean("user_session",false);
        boolean hr =!sharedPreferences.getString("hii","").isEmpty();

        boolean rrr = sharedPreferences.getBoolean("user_session",false) && !sharedPreferences.getString("hii","").isEmpty();
        Toast.makeText(this, ""+hemal+" "+rrr, Toast.LENGTH_SHORT).show();


        if(sharedPreferences.getBoolean("user_session",false) && !sharedPreferences.getString("hii","").isEmpty())
        {
            Intent i = new Intent(MainActivity.this,MainActivity2.class);
            startActivity(i);
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = txt1.getText().toString();
                String pass = txt2.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("hii",name);
                editor.putString("hemal",pass);
                editor.putBoolean("user_session",true);
                editor.apply();
                editor.commit();

                Intent i =new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
    }
}