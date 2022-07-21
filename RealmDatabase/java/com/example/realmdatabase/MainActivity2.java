package com.example.realmdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;
    List<Model> list;
    Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.list);
        list = new ArrayList<>();
        realm = Realm.getInstance(Realm.getDefaultConfiguration());

        realm.beginTransaction();

        RealmResults<Model> result = realm.where(Model.class).findAll();
        for (Model m : result) {
            list.add(m);
        }

        MyAdapter adapter = new MyAdapter(MainActivity2.this, list);
        listView.setAdapter(adapter);

        realm.commitTransaction();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity2.this);
                alert.setPositiveButton("UPDATE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AlertDialog.Builder alert2 = new AlertDialog.Builder(MainActivity2.this);
                        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
                        View view1 = inflater.inflate(R.layout.update,null);
                        alert2.setView(view1);

                        EditText upd1=view1.findViewById(R.id.upd1);
                        EditText upd2=view1.findViewById(R.id.upd2);

                        upd1.setText(list.get(position).name);
                        upd2.setText(list.get(position).password);

                        //EditText edt1 = view.findViewById(R.id.edt1);

                        alert2.setPositiveButton("UPDATE", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                String name = upd1.getText().toString();
                                String pass = upd2.getText().toString();

                                realm.beginTransaction();

                                list.get(position).setName(name);
                                list.get(position).setPassword(pass);

                                realm.commitTransaction();
                                Toast.makeText(MainActivity2.this, "Updated", Toast.LENGTH_SHORT).show();
                                Intent i1 =new Intent(MainActivity2.this,MainActivity2.class);
                                startActivity(i1);
                            }
                        });
                        alert2.show();
                    }
                });

                alert.setNegativeButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        realm.beginTransaction();
                        RealmResults<Model>deletedata = realm.where(Model.class).findAll();
                        deletedata.deleteFromRealm(position);
                        realm.commitTransaction();

                        Toast.makeText(MainActivity2.this, "Deleted", Toast.LENGTH_SHORT).show();
                        Intent in = new Intent(MainActivity2.this,MainActivity2.class);
                        startActivity(in);
                    }
                });
                alert.show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}