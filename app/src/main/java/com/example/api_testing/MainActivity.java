package com.example.api_testing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button getid,getbyid,getbyname;
    EditText input;
    ListView ls;
    TextView name;
    Weathereport weathereport=new Weathereport(MainActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //button assign
        getid=findViewById(R.id.get_city_id);
        getbyid=findViewById(R.id.get_by_id);
        getbyname=findViewById(R.id.get_by_name);
        input=findViewById(R.id.input);
        ls=findViewById(R.id.ls);
        name=findViewById(R.id.name_id);

        getid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weathereport.getcity(input.getText().toString(), new Weathereport.VolleyResponseListener() {
                    @Override
                    public void onerror(String message) {
                       //Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
                        name.setText("Invalid name");
                    }

                    @Override
                    public void onresponse(String cityid) {
                     // Toast.makeText(MainActivity.this,cityid,Toast.LENGTH_LONG).show();
                        name.setText(cityid);
                    }
                });




            }
        });
        getbyid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               weathereport.getbyid(input.getText().toString(), new Weathereport.Getbyidinterface() {
                   @Override
                   public void onresponse(List<weathermodel> weathermodels,String city) {
                       ArrayAdapter adapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,weathermodels);
                       ls.setAdapter(adapter);
                       name.setText(city);
                      // Toast.makeText(MainActivity.this,weathermodels.get(0).toString(),Toast.LENGTH_LONG).show();
                   }

                   @Override
                   public void onerror(String message) {
                       ls.setAdapter(null);
                       name.setText("Invalid");
                     //  Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();


                   }
               });
            }
        });
        getbyname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weathereport.getbyname(input.getText().toString(), new Weathereport.Getbynameinterface() {
                    @Override
                    public void onresponse(List<weathermodel> weathermodels) {
                        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,weathermodels);
                        ls.setAdapter(adapter);
                        name.setText(input.getText().toString());
                    }

                    @Override
                    public void onerror(String message) {
                        name.setText("Invalid");
                        ls.setAdapter(null);

                    }
                });

                //Toast.makeText(getApplicationContext(),"3",Toast.LENGTH_SHORT).show();
            }
        });

    }

}