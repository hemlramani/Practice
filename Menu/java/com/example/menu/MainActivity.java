package com.example.menu;

import static android.Manifest.permission.CALL_PHONE;
import static android.Manifest.permission.CAMERA;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5;
    //@RequiresApi(api = Build.VERSION_CODES.M)



    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);

        /*if (checkSelfPermission(CALL_PHONE)==PackageManager.PERMISSION_GRANTED)
        {
            return;
        }
        else
        {
            requestPermissions(new String[]{CALL_PHONE},100);
        }*/

        /*if(ContextCompat.checkSelfPermission(MainActivity.this, CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
        {

        }*/

        if (ContextCompat.checkSelfPermission(MainActivity.this, CALL_PHONE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[] { CALL_PHONE }, 100);
        }
        else {
            Toast.makeText(MainActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
        }

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "hii", Toast.LENGTH_SHORT).show();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater in = LayoutInflater.from(MainActivity.this);
               View v1= in.inflate(R.layout.design,null);
                Toast toast = new Toast(MainActivity.this);
                toast.setView(v1);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater in = LayoutInflater.from(MainActivity.this);
                View v2= in.inflate(R.layout.design,null);
                alert.setView(v2);
                TextView txt1= v2.findViewById(R.id.txt);
                txt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "done", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();

            }
        });
        registerForContextMenu(btn3);






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.i1:
                String num="6354537665";
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+num));
                startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.context,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.i2:
                Toast.makeText(this, "YEHH", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
