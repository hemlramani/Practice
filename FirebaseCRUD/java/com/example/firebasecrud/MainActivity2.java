package com.example.firebasecrud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {


    EditText e1,e2,e3;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        btn1=findViewById(R.id.btn1);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=e1.getText().toString();
                String e=e2.getText().toString();
                String p=e3.getText().toString();

                HashMap hashMap = new HashMap();
                hashMap.put("name",n);
                hashMap.put("email",e);
                hashMap.put("password",p);

                FirebaseDatabase.getInstance().getReference()
                        .child("employee")
                        .push()
                        .setValue(hashMap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(MainActivity2.this, "Inserted", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity2.this,MainActivity.class));
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity2.this, "Error", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}