package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageSlider slider;
    ListView listView;
    List<Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        slider=findViewById(R.id.sli1);
        listView=findViewById(R.id.list1);
        list=new ArrayList<>();

        list.add(new Model(R.drawable.vegpizza,"Veg Pizza",""));
        list.add(new Model(R.drawable.nonveg,"NonVeg Pizza",""));
        list.add(new Model(R.drawable.pizzamania,"Pizza Mania",""));
        list.add(new Model(R.drawable.sidesbeverages,"Beverages",""));



        MyAdapter adapter = new MyAdapter(MainActivity.this,list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, ""+i, Toast.LENGTH_SHORT).show();
                switch (i)
                {
                    case 0:
                        Intent in1 = new Intent(MainActivity.this,VegPizza.class);
                        startActivity(in1);
                        break;

                    case 1:
                        Intent in2 = new Intent(MainActivity.this,NonVegPizza.class);
                        startActivity(in2);
                        break;

                    case 2:
                        Intent i3 = new Intent(MainActivity.this,PizzaMania.class);
                        startActivity(i3);
                        break;

                    case  3:
                        Intent i4 = new Intent(MainActivity.this,Beverages.class);
                        startActivity(i4);
                        break;



                }
            }
        });

        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://api.dominos.co.in/prod-olo-api/images/Home_Paytm_20210519.jpg",null));
        slideModels.add(new SlideModel("https://api.dominos.co.in/prod-olo-api/images/Home_airtel_30082020.jpg",null));
        slideModels.add(new SlideModel("https://api.dominos.co.in/prod-olo-api/images/Home_Freecharge_20210405.jpg",null));
        slideModels.add(new SlideModel("https://api.dominos.co.in/prod-olo-api/images/amazon_home_20210412.jpg",null));
        slideModels.add(new SlideModel("https://api.dominos.co.in/prod-olo-api/images/Dominos_Mobi_Home_20210503.jpg",null));
        slideModels.add(new SlideModel("https://api.dominos.co.in/prod-olo-api/images/Home_payzapp_20201029.jpg",null));

        slider.setImageList(slideModels, ScaleTypes.FIT);

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}