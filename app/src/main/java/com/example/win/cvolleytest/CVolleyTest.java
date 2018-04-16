package com.example.win.cvolleytest;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WIN on 23/2/2018.
 */

public class CVolleyTest {

    RequestQueue rq;
    private Context ctx;
    final String strURL = "http://www.suryatotalpertiwi.com/tandroid/DBinsert2.php";
    public CVolleyTest(Context c){
        ctx = c;
    }

    /** fetch **/
    public JSONObject fetch(){
        rq = Volley.newRequestQueue(ctx);
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, strURL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try{

                            //ja = response.getJSONArray("DBfeth2.php");
                            return response;

                        }catch(JSONException e){e.printStackTrace();}
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley","Error");

                    }
                }
        );
    }
    /** write **/
    public Boolean write(final String str){
        rq = Volley.newRequestQueue(ctx);
        StringRequest srQ = new StringRequest(Request.Method.POST, strURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // do something
                        Toast.makeText(ctx,"Success...", Toast.LENGTH_LONG)
                                .show();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // error action
                Toast.makeText(ctx, error.toString(), Toast.LENGTH_LONG)
                        .show();
            }}){
            @Override
            protected Map<String,String> getParams() {
                Map<String,String> params = new HashMap<String,String>();
                params.put("textname", str);
                return params;
            }
        };
        rq.add(srQ);
        return true;
    }
    /** read **/
}
