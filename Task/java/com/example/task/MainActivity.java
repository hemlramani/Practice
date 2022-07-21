package com.example.task;

import static android.Manifest.permission.CALL_PHONE;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {




    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(checkSelfPermission(CALL_PHONE)== PackageManager.PERMISSION_GRANTED)
        {
            return;
        }
        else
        {
            requestPermissions(new String[]{CALL_PHONE},100);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.all_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.i1:
            {
                String num = "9879056972";
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:"+num));
                startActivity(i);

            }
            case R.id.i2:
            {
                String msg= "HELLO HEMAL";
                Intent i = new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"@hemalhramani4@gmail.com"});
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_SUBJECT,"SUBJECT");
                i.putExtra(Intent.EXTRA_TEXT,"HELLO");
                //i.setData(Uri.parse(msg));
                startActivity(i);
                break;

            }

            case R.id.i3:
            {
                Intent i = new Intent(Intent.ACTION_SEND_MULTIPLE);
                i.setType("plain/text");
                i.putExtra(Intent.EXTRA_TEXT,"I am Hemal Ramani");
                startActivity(i);
            }
        }

        return super.onOptionsItemSelected(item);
    }
}