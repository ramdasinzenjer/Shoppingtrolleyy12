package com.ram.ram.shoppingtrolley;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class home extends AppCompatActivity {

    TextView txt;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txt = findViewById(R.id.text);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this,Scanner.class));
            }
        });
        if (Const.barcode!=null)
        {
            txt.setText(Const.barcode);
            upload(Const.barcode);
        }
    }

    private void upload(final String barcode) {
        StringRequest strReq = new StringRequest(Request.Method.GET,
                Const.url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d("sssss", response.toString());

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("cccc", "Error: " + error.getMessage());
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("barcode", barcode);

                return params;
            }
        };
    }
}
