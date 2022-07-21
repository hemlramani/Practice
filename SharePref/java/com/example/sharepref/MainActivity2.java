package com.example.sharepref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sharedPreferences=getSharedPreferences("user_session", Context.MODE_PRIVATE);

        Toast.makeText(MainActivity2.this, "welcome "+sharedPreferences.getString("hii",""), Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity2.this, "welcome "+sharedPreferences.getString("hemal",""), Toast.LENGTH_SHORT).show();
    }
}