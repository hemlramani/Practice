package com.example.practice1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class First extends Fragment {

   TextView txt1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_first, container, false);

        txt1=view.findViewById(R.id.txt1);


        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Second sf = new Second();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frm1,sf).commit();

            }
        });

        return view;
    }
}