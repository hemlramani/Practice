package com.example.onlinedatabse7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

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
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<Model> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        list= new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://api.androidhive.info/contacts/", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("contacts");
                    for (int i=0;i<jsonArray.length(); i++)
                    {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        JSONObject jsonObject2 = jsonObject1.getJSONObject("phone");




                        String name = jsonObject1.getString("name");
                        String email = jsonObject1.getString("email");
                        String adress = jsonObject1.getString("address");
                        String gender = jsonObject1.getString("gender");
                        String mobile = jsonObject2.getString("mobile");
                        String home = jsonObject2.getString("home");
                        String office = jsonObject2.getString("office");

                        Model model = new Model();
                        model.setName(name);
                        model.setEmail(email);
                        model.setAdress(adress);
                        model.setGender(gender);
                        model.setMobile(mobile);
                        model.setHome(home);
                        model.setOffice(office);
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
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}