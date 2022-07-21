package com.example.task5;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


public class Programming extends Fragment {


    TextView txt3;
    ImageButton imageButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_programming, container, false);

        txt3=view.findViewById(R.id.txt3);
        imageButton=view.findViewById(R.id.imageButton);
        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater1 = LayoutInflater.from(getContext());
                View view1 = inflater1.inflate(R.layout.design2,null);
                alert.setView(view1);
                alert.show();





            }

        });



        return view;
    }
}