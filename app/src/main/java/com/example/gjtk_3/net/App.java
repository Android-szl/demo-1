package com.example.gjtk_3.net;

import android.app.Application;

public class App extends Application {
    private static String Token="";
    public static String getToken(){
        return Token;
    }

    public static void setToken(String token) {
        Token = token;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
