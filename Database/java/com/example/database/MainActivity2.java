package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    ListView listView;
    List<Model> list;
    DbHelper dbHelper;
    ArrayList<HashMap<String,String>>arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView=findViewById(R.id.list);
        list=new ArrayList<>();
        dbHelper=new DbHelper(MainActivity2.this);

        list=dbHelper.viewdata();

        for(Model m:list)
        {
            HashMap map=new HashMap();
            map.put("id",m.getId());
            map.put("name",m.getName());
            map.put("number",m.getNumber());
            arrayList.add(map);
        }




        String from[]={"name","number"};
        int to[]={R.id.txt1,R.id.txt2};

        SimpleAdapter simpleAdapter=new SimpleAdapter(MainActivity2.this,arrayList,R.layout.design,from,to);
        listView.setAdapter(simpleAdapter);
    }

    @Override
    public void onBackPressed()
    {
        finishAffinity();
    }
}