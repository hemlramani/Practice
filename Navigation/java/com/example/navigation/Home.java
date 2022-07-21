package com.example.navigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class Home extends Fragment {

    ListView listView;
    List<String> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        listView=view.findViewById(R.id.list1);
        list=new ArrayList<>();

        list.add("Android");
        list.add("Java");
        list.add("Php");



        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);

        return view;
    }
}