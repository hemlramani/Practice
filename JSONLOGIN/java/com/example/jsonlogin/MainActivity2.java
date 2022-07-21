package com.example.jsonlogin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class MainActivity2 extends AppCompatActivity {

    EditText edtmob,edtpass;
    Button btnlogin;
    TextView txtregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edtmob=findViewById(R.id.edtmob);
        edtpass = findViewById(R.id.edtpass);
        btnlogin = findViewById(R.id.btnlogin);
        txtregister = findViewById(R.id.txtregister);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mobile = edtmob.getText().toString();
                String pass  = edtpass.getText().toString();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://vyasprakruti.000webhostapp.com/E-Greetings%20Project/login.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("0"))
                        {
                            Toast.makeText(MainActivity2.this, "Fail", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(MainActivity2.this, "Success", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity2.this, "No Internet", Toast.LENGTH_SHORT).show();
                    }
                })
                {
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        HashMap hashMap = new HashMap();
                        hashMap.put("phone",mobile);
                        hashMap.put("pass",pass);
                        return hashMap;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity2.this);
                requestQueue.add(stringRequest);

            }
        });
        txtregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}