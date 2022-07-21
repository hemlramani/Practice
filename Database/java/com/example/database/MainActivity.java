package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt1,edt2;
    Button btn1;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        btn1=findViewById(R.id.btninsert);
        dbHelper=new DbHelper(getApplicationContext());
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=edt1.getText().toString();
                String num=edt2.getText().toString();

                Model m =new Model();
                m.setName(name);
                m.setNumber(num);
                long id=dbHelper.savedata(m);

                Toast.makeText(MainActivity.this, "Record Inserted "+id, Toast.LENGTH_SHORT).show();
                Intent i =new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
    }
}