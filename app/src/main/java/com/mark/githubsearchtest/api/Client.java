package com.mark.githubsearchtest.api;

import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Client {

    String get(String url) throws IOException {


        OkHttpClient client = new OkHttpClient();

        // Request build
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        return doResponse(response);

    }

    private String doResponse(Response response) throws IOException {

        if (response.isSuccessful()) {
            String responseData = response.body().string();
            Log.d("MyHeader", "" + response.header("Link"));
            return responseData;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }
}
