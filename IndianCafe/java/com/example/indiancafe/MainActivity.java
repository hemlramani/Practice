package com.example.indiancafe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chk1,chk2,chk3,chk4,chk5;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chk1= findViewById(R.id.chk1);
        chk2= findViewById(R.id.chk2);
        chk3= findViewById(R.id.chk3);
        chk4= findViewById(R.id.chk4);
        chk5= findViewById(R.id.chk5);
        btn1= findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuilder builder = new StringBuilder();
                builder.append("\nSelected Items\n");
                int price=0;

                if(chk1.isChecked())
                {
                    price+=150;
                    builder.append("\n PIZZA Rs. 150\n");
                }
                if(chk2.isChecked())
                {
                        price+=70;
                    builder.append("\n BURGER Rs. 70\n");
                }
                if(chk3.isChecked())
                {
                        price+=50;
                    builder.append("\n SANDWICH Rs. 50\n");
                }
                if(chk4.isChecked())
                {
                        price+=120;
                    builder.append("\n FRENCH FRIES Rs. 120\n");
                }
                if(chk5.isChecked())
                {
                        price+=100;
                    builder.append("\n ICE-CREAM Rs. 100\n");
                }
                builder.append("\n Total Price : "+price);
                Toast.makeText(MainActivity.this, "Total Rs. : "+price, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this,Bill.class);
                i.putExtra("bill",builder.toString());
                startActivity(i);
            }
        });
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Are you sure to exit?");
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();
            }
        });

        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        alert.show();

    }
}