package com.example.jsoncrud;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity3 extends AppCompatActivity {

    EditText upd1,upd2,upd3;
    Button btnupdate;
    String id,name,price,des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        upd1= findViewById(R.id.upd1);
        upd2 = findViewById(R.id.upd2);
        upd3 = findViewById(R.id.upd3);
        btnupdate = findViewById(R.id.btnupdate);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        name = intent.getStringExtra("product_name");
        price = intent.getStringExtra("product_price");
        des = intent.getStringExtra("product_des");

        upd1.setText(name);
        upd2.setText(price);
        upd3.setText(des);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 name = upd1.getText().toString();
                 price = upd2.getText().toString();
                 des = upd3.getText().toString();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, MyUrl.update, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(MainActivity3.this, "Updated", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(MainActivity3.this,MainActivity2.class);
                        startActivity(intent1);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity3.this, "No Internet", Toast.LENGTH_SHORT).show();
                    }
                })
                {
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        HashMap hashMap = new HashMap();
                        hashMap.put("id",id);
                        hashMap.put("p_name",name);
                        hashMap.put("p_price",price);
                        hashMap.put("p_des",des);

                        return hashMap;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity3.this);
                requestQueue.add(stringRequest);


            }
        });

    }
}