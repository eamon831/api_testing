package com.example.api_testing;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Weathereport {
    public static final String link ="https://www.metaweather.com/api/location/search/?query=";
    public static final String link_id="https://www.metaweather.com/api/location/";
    Context context;
    String city;

    public Weathereport(Context context) {
        this.context = context;
    }




    public interface VolleyResponseListener{
        void onerror(String message);
        void onresponse(String cityid);
    }


    public void getcity(String cityname,VolleyResponseListener volleyResponseListener)
    {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url =link+cityname;


        JsonArrayRequest request=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String cityid="";
                try {
                    JSONObject cityinfo=response.getJSONObject(0);
                    cityid=cityinfo.getString("woeid");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                volleyResponseListener.onresponse(cityid);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyResponseListener.onerror("something wrong");

            }
        });
        queue.add(request);


    }
    public  interface Getbyidinterface{
        void onresponse(List<weathermodel> weathermodels,String city);
        void onerror(String message);
    }
    public void getbyid(String id,final Getbyidinterface getbyidinterface) {
        List<weathermodel> days=new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(context);
        String url =link_id+id;

        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
               // Toast.makeText(context,response.toString(),Toast.LENGTH_LONG).show();
                try {
                    JSONArray consolidated_weather_list=response.getJSONArray("consolidated_weather");
                   String city= (String) response.get("title");
                   Toast.makeText(context,city,Toast.LENGTH_LONG).show();



                    for(int i=0;i<consolidated_weather_list.length();i++)
                    {
                        weathermodel one_day=new weathermodel();
                        JSONObject one_day_from_api= (JSONObject) consolidated_weather_list.get(i);
                        one_day.setId(one_day_from_api.getInt("id"));
                        one_day.setWeather_state_name(one_day_from_api.getString("weather_state_name"));
                        one_day.setWeather_state_abbr(one_day_from_api.getString("weather_state_abbr"));
                        one_day.setWind_direction_compass(one_day_from_api.getString("wind_direction_compass"));
                        one_day.setCreated(one_day_from_api.getString("created"));
                        one_day.setApplicable_date(one_day_from_api.getString("applicable_date"));
                        one_day.setMin_temp(one_day_from_api.getDouble("min_temp"));
                        one_day.setMax_temp(one_day_from_api.getDouble("max_temp"));
                        one_day.setThe_temp(one_day_from_api.getDouble("the_temp"));
                        one_day.setWind_speed(one_day_from_api.getDouble("wind_speed"));
                        one_day.setWind_directon(one_day_from_api.getDouble("wind_direction"));
                        one_day.setAir_pressure(one_day_from_api.getDouble("air_pressure"));
                        one_day.setHumidity(one_day_from_api.getInt("humidity"));
                        one_day.setVisibility(one_day_from_api.getDouble("visibility"));
                        one_day.setPredict(one_day_from_api.getInt("predictability"));
                        days.add(one_day);



                    }
                   // Toast.makeText(context,days.get(2).toString(),Toast.LENGTH_LONG).show();
                    getbyidinterface.onresponse(days,city);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // Toast.makeText(context,"something wrong",Toast.LENGTH_LONG).show();
                getbyidinterface.onerror("something wrong");
            }
        });
        queue.add(request);

    }
    public interface Getbynameinterface{
        void onresponse(List<weathermodel> weathermodels);
        void onerror(String message);
    }
    public void getbyname(String cityname,Getbynameinterface getbynameinterface) {
         getcity(cityname, new VolleyResponseListener() {
             @Override
             public void onerror(String message) {

             }

             @Override
             public void onresponse(String cityid) {
                 getbyid(cityid, new Getbyidinterface() {
                     @Override
                     public void onresponse(List<weathermodel> weathermodels,String city) {
                         getbynameinterface.onresponse(weathermodels);
                     }

                     @Override
                     public void onerror(String message) {
                         getbynameinterface.onerror("error");

                     }
                 });

             }
         });


    }

}
