package com.example.fragment3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FirstFragment extends Fragment {

    TextView ffirst;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_first, container, false);

        ffirst=view.findViewById(R.id.ffirst);

        ffirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SecondFragment secondFragment = new SecondFragment();
                FragmentManager fm= getFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.fid,secondFragment).commit();

            }
        });

        return view;





    }
}