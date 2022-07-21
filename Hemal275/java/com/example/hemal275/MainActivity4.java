package com.example.hemal275;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    Switch swich;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        swich=findViewById(R.id.swich);
        mediaPlayer=mediaPlayer.create(MainActivity4.this,R.raw.ringing_old_phone);

        swich.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (swich.isChecked())
                {
                    Toast.makeText(MainActivity4.this, "ON", Toast.LENGTH_SHORT).show();
                    mediaPlayer.start();
                }
                else
                {
                    Toast.makeText(MainActivity4.this, "OFF", Toast.LENGTH_SHORT).show();
                    mediaPlayer.stop();
                }
            }
        });
    }
}