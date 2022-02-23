package com.example.gjtk_3.net;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class OkHttpTo extends Thread {
    public String IP = "http://192.168.155.204:8080/city/";
    private OkHttpLo okHttpLo;
    private JSONObject jsonObject = new JSONObject();
    private String type;
    private String Token=App.getToken();
    private String url = "http://124.93.196.45:10001";
    private int id;


    public OkHttpTo setOkHttpLo(OkHttpLo okHttpLo) {
        this.okHttpLo = okHttpLo;
        return this;
    }


    public OkHttpTo setId(int id) {
        this.id = id;
        return this;
    }

    public OkHttpTo setIP(String IP) {
        this.IP += IP;
        return this;
    }

    public OkHttpTo setJsonObject(String k, Object v) {
        try {
            jsonObject.put(k, v);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }
    public OkHttpTo setToken(String token) {
        Token = token;
        return this;
    }
    public OkHttpTo setType(String type) {
        this.type = type;
        return this;
    }

    public OkHttpTo setUrl(String url) {
        this.url += url;
        return this;
    }

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            okHttpLo.onResponse((JSONObject) msg.obj);
            return false;
        }
    });

    @Override
    public void run() {
        super.run();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        RequestBody body = null;
        MediaType mediaType = MediaType.parse("application/json");
        if (type.equalsIgnoreCase("POST") ||
                type.equalsIgnoreCase("PUT")) {
            body = RequestBody.create(mediaType, jsonObject.toString());
        }
        Request request = new Request.Builder()
                .url(id == 1 ? IP : url)
                .method(type.toUpperCase(), body)
                .addHeader("Authorization", App.getToken())
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            Message msg = Message.obtain();
            msg.obj = new JSONObject(Objects.requireNonNull(response.body()).string());
            handler.sendMessage(msg);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}