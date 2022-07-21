package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageSlider imageSlider1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSlider1 = findViewById(R.id.sld1);

        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.girnar,null));
        slideModels.add(new SlideModel("https://www.gstatic.com/webp/gallery/2.jpg",null));
        slideModels.add(new SlideModel("https://www.gstatic.com/webp/gallery/1.jpg",null));

        imageSlider1.setImageList(slideModels,ScaleTypes.FIT);


            
        }



    }
