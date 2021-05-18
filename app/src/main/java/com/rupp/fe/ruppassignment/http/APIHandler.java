package com.rupp.fe.ruppassignment.http;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import org.json.JSONObject;

public class APIHandler {
    private final Context context;

    public APIHandler(Context context) {
        this.context = context;
    }

    public <M> void get(String endPoint, Class<M> model, APICallBack apiCallBack) {

        new MyJSONObjectRequest(context) {
            @Override
            public String getFunctionName() {
                return endPoint;
            }

            @Override
            public int getMethod() {
                return Request.Method.GET;
            }
        }.setOnErrorListener(new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("TAG", "onErrorResponse: error " + error);
                if (error != null)
                    apiCallBack.responseError(DRequest.getErrorMessageFrom(error, ""));
            }
        }).execute((Response.Listener<JSONObject>) response -> {

            apiCallBack.responseData(new Gson().fromJson(response.toString(), model));
        });
    }
}