package com.example.sqlitedatabase2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    ListView listView;
    List<Model> list;
    DbHelper dbHelper;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView = findViewById(R.id.list);


        list = new ArrayList<>();
        dbHelper = new DbHelper(MainActivity2.this);

        list = dbHelper.readdata();

        for (Model m : list) {
            HashMap map = new HashMap();
            map.put("id", m.getId());
            map.put("name", m.getName());
            map.put("number", m.getNumber());
            arrayList.add(map);
        }

        String from[] = {"name", "number"};
        int to[] = {R.id.txt1, R.id.txt2};
        SimpleAdapter adapter = new SimpleAdapter(MainActivity2.this, arrayList, R.layout.design, from, to);

        listView.setAdapter(adapter);
        registerForContextMenu(listView);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuItem m1 = menu.add(0, 1, 0, "Update");
        MenuItem m2 = menu.add(0, 2, 0, "Delete");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        AdapterView.AdapterContextMenuInfo acm = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int id = acm.position;
        Model model = list.get(id);
        switch (item.getItemId()) {
            case 1:

                Intent in1 = new Intent(MainActivity2.this, MainActivity3.class);
                in1.putExtra("id", model.getId());
                in1.putExtra("name", model.getName());
                in1.putExtra("number", model.getNumber());
                startActivity(in1);
                break;

            case 2:
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity2.this);
                alert.setTitle("Select Operation");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dbHelper.deletedata(model.getId());

                        Intent in = new Intent(MainActivity2.this, MainActivity2.class);
                        startActivity(in);

                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                alert.show();
                break;


        }

        return super.onContextItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}