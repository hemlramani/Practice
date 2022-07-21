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

public class MainActivity extends AppCompatActivity {

    EditText edtfname,edtlname,edtemail,edtmobile,edtpass;
    Button btnregister;
    TextView txtlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        edtfname = findViewById(R.id.edtfname);
        edtlname = findViewById(R.id.edtlname);
        edtemail = findViewById(R.id.edtemail);
        edtmobile = findViewById(R.id.edtmob);
        edtpass = findViewById(R.id.edtpass);
        btnregister = findViewById(R.id.btnregister);
        txtlogin = findViewById(R.id.txtlogin);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fname = edtfname.getText().toString();
                String lname = edtlname.getText().toString();
                String email = edtemail.getText().toString();
                String mobile = edtmobile.getText().toString();
                String pass = edtpass.getText().toString();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://vyasprakruti.000webhostapp.com/E-Greetings%20Project/registration.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(MainActivity.this, "Register Complate", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "No Internet", Toast.LENGTH_SHORT).show();
                    }
                })
                {

                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {


                        HashMap hashMap = new HashMap();
                        hashMap.put("firstname",fname);
                        hashMap.put("lastname",lname);
                        hashMap.put("email",email);
                        hashMap.put("phone",mobile);
                        hashMap.put("password",pass);



                        return hashMap;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                requestQueue.add(stringRequest);

            }
        });


        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(i);
            }
        });
        

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}