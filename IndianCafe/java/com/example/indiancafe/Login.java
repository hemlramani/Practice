package com.example.indiancafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText edt1,edt2;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        btn1=findViewById(R.id.btn1);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = edt1.getText().toString();
                String pass = edt2.getText().toString();

                if(name.length()==0 && pass.length()==0)
                {
                    edt1.setError("Please enter your name");
                    edt2.setError("please enter your Password");
                }
                else if(name.length()==0)
                {
                    edt1.setError("Please enter your name");
                }
                else if(pass.length()==0)
                {
                    edt2.setError("please enter your Password");
                }
                else
                {
                    if(name.equals("admin") && pass.equals("1234"))
                    {
                        Toast.makeText(Login.this, "Success", Toast.LENGTH_SHORT).show();

                        Intent i =new Intent(Login.this,MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(Login.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}