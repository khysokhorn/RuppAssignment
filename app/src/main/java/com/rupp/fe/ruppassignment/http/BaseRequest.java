package com.rupp.fe.ruppassignment.http;

import android.content.Context;
import android.util.Log;

import com.android.volley.VolleyError;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseRequest<T> extends DRequest<T> {

    public abstract String getFunctionName();

    private final String host;

    public BaseRequest(Context context) {
        super(context);
        host = "https://www.googleapis.com";
    }

    @Override
    public String getBaseUrl() {
        return host + getFunctionName().replaceAll("\\s+", "");
    }

    @Override
    public Map<String, String> onCreateHeader(Map header) {
        HashMap<String, String> mheader = getHeader();
        Log.d("HEADER:>>>", mheader.toString());
        return mheader;
    }

    private HashMap<String, String> getHeader() {
        String token = "ya29.a0AfH6SMCaoCZcd4EaFLU9CocF6DYElecRajaNgQSX52ZMk9CsG75-LjHe49fChWiuyFScUqFYYtx6GFlSvWmLJsPIAkrc6YfPGrt1cc4akymZKz6IDsvN3OpqBoTxOZIoa8MI9I2ezrf6KO54vN5uReKKmT6A";
        HashMap<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer " + token);
        header.put("Content-Type", "application/json; charset=utf-8");

        return header;
    }

    @Override
    public void onError(VolleyError error) {
        super.onError(error);
    }

}
