package onetaptakeaway.spinno.com.volleyjsonobjectlearning;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {



    final String URL = "http://www.muntumi.net:8083/socal/services/adduser.json";

    String url = "http://api.androidhive.info/volley/person_object.json";

    RequestQueue queue ;
    JsonObjectRequest req ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = VolleySingleton.getInstance(MainActivity.this).getRequestQueue();


      /*  HashMap<String, String> params = new HashMap<String, String>();
        params.put("email", "samirgoel3@gmail.com");
        params.put("password", "12345678");
        req = new JsonObjectRequest(URL, new JSONObject(params),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            VolleyLog.v("Response:%n %s", response.toString(4));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        });   */


////////////////////////   working perfect for getting json object values
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                URL, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("######", response.toString());
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("******", "Error: " + error.getMessage());
                // hide the progress dialog
            }
        });


///////////////////////   for posting parameters in JSON
      /*  Map<String, String> jsonParams = new HashMap<String, String>();
        jsonParams.put("param1", "blabla");
        JsonObjectRequest myRequest = new JsonObjectRequest(
                Request.Method.POST,
                URL,
                new JSONObject(jsonParams),

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(MainActivity.this, "yessssssss", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "noooooooooo  " + error, Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("firstname", "samir");
                params.put("lastname", "goel");
                params.put("preferredname", "sam");
                params.put("email", "samirgoel3@gmail.com");
                params.put("suburbid", "54");
                params.put("dob", "7/aug/1990");
                params.put("userhandle", "unknown");
                params.put("userpass", "12345678");
                params.put("telephone", "1234567896");


                return params;
            }

        };  */












        Map<String, String> params = new HashMap<String, String>();
        params.put("firstname", "samir");
        params.put("lastname", "goel");
        params.put("preferredname", "sam");
        params.put("email", "samirgoel3@gmail.com");
        params.put("suburbid", "54");
        params.put("dob", "1990-08-07");
        params.put("userhandle", "unknown");
        params.put("userpass", "1234567A8");
        params.put("telephone", "1234567896");


        Log.d("jason ", "" + params);

        JsonObjectRequest myRequestsecond = new JsonObjectRequest(
                Request.Method.PUT,
                URL,
                new JSONObject(params),

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //verificationSuccess(response);
                        Log.d("#########" ,""+response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("#########******", "" +error);
                    }
                });

















        StringRequest sr = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               Log.d("Sucess" ,""+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Sucess", "" + error);
            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("firstname", "samir");
                params.put("lastname", "goel");
                params.put("preferredname", "sam");
                params.put("email", "samirgoel3@gmail.com");
                params.put("suburbid", "54");
                params.put("dob", "1990-08-07");
                params.put("userhandle", "unknown");
                params.put("userpass", "1234567A8");
                params.put("telephone", "1234567896");

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type","application/x-www-form-urlencoded");
                return params;
            }
        };


        queue.add(sr);





    }}
