package com.example.tab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.teal_700));

        toolbar=findViewById(R.id.tool1);
        setSupportActionBar(toolbar);

        viewPager=findViewById(R.id.view1);
        setupviewpager();

        tabLayout=findViewById(R.id.ta1);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupviewpager() {
        MyAdapter myAdapter=new MyAdapter(getSupportFragmentManager());
        myAdapter.addfragment("CHAT",new Chat());
        myAdapter.addfragment("STATUS",new Status());
        myAdapter.addfragment("CALL",new Call());
        viewPager.setAdapter(myAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}