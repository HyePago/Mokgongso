package com.example.hyejin.mokgongso_stack;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Mirim on 2018-05-26.
 */

public class FacebookTokenURLConnection {
    interface RequestCallback {
        // 생성시의 Callback
        void success(FBResult fbResult);

        // 실패시의 Callback
        void error(Throwable throwable);
    }

    public static final String TAG = FacebookTokenURLConnection.class. getSimpleName();

    // URL values
    String SCHEME = "http";
    String AUTHORITY = "http://iwin247.info:3113";
    String PATH = "/fb";
    String token = null;
    Uri uri;
    RequestQueue queue;

    public FacebookTokenURLConnection(Context context, String token){
        this.token = token;

        uri = new Uri.Builder()
                .scheme(SCHEME)
                .authority(AUTHORITY)
                .path(PATH)
                .appendQueryParameter("token", token)
                .build();

        queue = Volley.newRequestQueue(context);
    }

    public void getResponse(final RequestCallback callback) {
        final JsonObjectRequest request =
                new JsonObjectRequest(uri.toString(), null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "result: " + response.toString());
                        final FBResult weather = new Gson().fromJson(response.toString(), FBResult.class);
                        //callback.success(weather);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.error(error);
                    }
                });
        queue.add(request);
    }
}
