package com.example.slider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.google.android.material.slider.Slider;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    SliderLayout sliderLayout;
    HashMap<String,String> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderLayout=findViewById(R.id.slid1);

        hashMap.put("a","https://www.gstatic.com/webp/gallery/1.jpg");
        hashMap.put("b","https://www.gstatic.com/webp/gallery/2.jpg");
        hashMap.put("c","https://www.gstatic.com/webp/gallery/3.jpg");

        for (String s:hashMap.keySet()) {
            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            textSliderView.description(s)
                    .image(hashMap.get(s))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            sliderLayout.setPresetTransformer(SliderLayout.Transformer.FlipPage);
            sliderLayout.addSlider(textSliderView);
        }
    }
}