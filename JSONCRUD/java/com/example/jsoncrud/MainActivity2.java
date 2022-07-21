package com.example.jsoncrud;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {


    ListView listView;
    List<Model> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.list);
        list = new ArrayList<>();
        registerForContextMenu(listView);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, MyUrl.view, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i=0; i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        int id = jsonObject.getInt("id");
                        String name = jsonObject.getString("name");
                        String price = jsonObject.getString("email");
                        String des = jsonObject.getString("pass");

                        Model model = new Model();
                        model.setId(id);
                        model.setName(name);
                        model.setPrice(price);
                        model.setDes(des);
                        list.add(model);


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                MyAdapter adapter = new MyAdapter(getApplicationContext(),list);
                listView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity2.this, "No Internet", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity2.this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuItem item1 = menu.add(0,1,0,"Update");
        MenuItem item2 = menu.add(0,2,0,"Delete");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo acm = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int id =acm.position;
        Model model = list.get(id);

        switch (item.getItemId())
        {
            case 1 :
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                intent.putExtra("id",String.valueOf(model.getId()));
                intent.putExtra("product_name",model.getName());
                intent.putExtra("product_price",model.getPrice());
                intent.putExtra("product_des",model.getDes());
                startActivity(intent);

                break;

            case 2:
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity2.this);
                alert.setTitle("Delete?");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        StringRequest stringRequest = new StringRequest(Request.Method.POST, MyUrl.delete, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                Toast.makeText(MainActivity2.this, "Deleted", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(MainActivity2.this,MainActivity2.class));
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity2.this, "No Internet", Toast.LENGTH_SHORT).show();
                            }
                        })
                        {
                            @Nullable
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                HashMap hashMap = new HashMap();
                                hashMap.put("id",String.valueOf(model.getId()));
                                return hashMap;
                            }
                        };


                        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity2.this);
                        requestQueue.add(stringRequest);

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
}