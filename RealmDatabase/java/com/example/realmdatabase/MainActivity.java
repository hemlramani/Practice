package com.example.realmdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    EditText edt1,edt2;
    Button btn1,btn2;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        realm=Realm.getInstance(Realm.getDefaultConfiguration());

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name = edt1.getText().toString();
                String password = edt2.getText().toString();

                realm.beginTransaction();

                Model model = realm.createObject(Model.class);
                model.setName(name);
                model.setPassword(password);

                realm.commitTransaction();

                Toast.makeText(MainActivity.this, "Reacord Inserted", Toast.LENGTH_SHORT).show();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);

            }
        });
    }
}