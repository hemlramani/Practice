package com.example.gallary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spin1;
    String name[]={"Select Type","Animal","Birds","Nature","Farm"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.hemal)));
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.hemal));

        spin1=findViewById(R.id.spin1);

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,name);
        spin1.setAdapter(adapter);

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i)
                {
                    case 1:
                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Intent intent1 = new Intent(MainActivity.this,MainActivity3.class);
                        startActivity(intent1);
                        break;

                    case 3:
                        Intent intent2 = new Intent(MainActivity.this,MainActivity4.class);
                        startActivity(intent2);
                        break;

                    case 4:
                        Intent intent3 = new Intent(MainActivity.this,MainActivity5.class);
                        startActivity(intent3);
                        break;


                }



                Toast.makeText(MainActivity.this, ""+name[i], Toast.LENGTH_SHORT).show();




            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}