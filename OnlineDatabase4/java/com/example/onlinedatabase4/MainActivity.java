package com.example.onlinedatabase4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    RecyclerView recyclerView;
    List<Model> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycle);
        list=new ArrayList<>();

        RecyclerView.LayoutManager rl=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rl);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://vyasprakruti.000webhostapp.com/30Nov/Taskview.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int  i=0; i<jsonArray.length();i++)
                    {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String name1 = jsonObject.getString("name");
                        String surname1 = jsonObject.getString("surname");
                        String score1 = jsonObject.getString("highest_score");

                        Model model = new Model();
                        model.setName(name1);
                        model.setSurname(surname1);
                        model.setScore(score1);
                        list.add(model);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                MyAdapter adapter = new MyAdapter(getApplicationContext(),list);
                recyclerView.setAdapter(adapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
}