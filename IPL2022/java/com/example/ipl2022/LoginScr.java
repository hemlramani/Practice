package com.example.ipl2022;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginScr extends AppCompatActivity {

    EditText txt1,txt2;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_login_scr);

        txt1=findViewById(R.id.edt1);
        txt2=findViewById(R.id.edt2);
        btn1=findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String name=txt1.getText().Trim().toString();
                String name = txt1.getText().toString().trim();
                String pass=txt2.getText().toString().trim();

                if(name.length()==0 && pass.length()==0)
                {
                    txt1.setError("Please Enter Your Name");
                    txt2.setError("Please Enter Your Password");
                }
                else if (name.length()==0)
                {
                    txt1.setError("Please Enter Your Name");

                }
                else if(pass.length()==0)
                {
                    txt2.setError("Please Enter Your Password");
                }
                else
                {
                    if(name.equals("hemal")&&pass.equals("1234"))
                    {
                        Toast.makeText(LoginScr.this, "Success", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginScr.this,MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(LoginScr.this, "Wrong", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });



    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(LoginScr.this);
        alert.setTitle("Are You Sure to Exit?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
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