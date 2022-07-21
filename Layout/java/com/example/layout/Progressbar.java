package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Toast;

public class Progressbar extends AppCompatActivity implements View.OnClickListener, RatingBar.OnRatingBarChangeListener {

    ProgressBar pg1;
    Button btn1,btn2;
    RatingBar rate1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);

        pg1=findViewById(R.id.prg1);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        rate1=findViewById(R.id.rate1);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        rate1.setOnRatingBarChangeListener(this);



    }

    @Override
    public void onClick(View view) {
        if (view==btn1)
        {
            pg1.incrementProgressBy(1);
            setProgress(100*pg1.getProgress());

        }
        if(view==btn2)
        {
            pg1.incrementProgressBy(-1);
            setProgress(100*pg1.getProgress());
        }
    }


    @Override
    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
        String r = String.valueOf(ratingBar.getRating());
        Toast.makeText(this, ""+r, Toast.LENGTH_SHORT).show();
    }
}