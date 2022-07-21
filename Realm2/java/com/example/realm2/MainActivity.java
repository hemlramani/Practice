package com.example.realm2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}