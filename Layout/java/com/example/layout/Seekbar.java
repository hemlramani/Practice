package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class Seekbar extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBar seek1,seek2,seek3;
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);

        seek1=findViewById(R.id.seek1);
        seek2=findViewById(R.id.seek2);
        seek3=findViewById(R.id.seek3);
        img1=findViewById(R.id.img);

        seek1.setOnSeekBarChangeListener(this);
        seek2.setOnSeekBarChangeListener(this);
        seek3.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        int red = seek1.getProgress();
        int green = seek2.getProgress();
        int blue = seek3.getProgress();

        img1.setBackgroundColor(Color.rgb(red,green,blue));


    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}