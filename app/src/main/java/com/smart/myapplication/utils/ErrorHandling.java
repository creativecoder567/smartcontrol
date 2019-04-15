package com.smart.myapplication.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import static com.smart.myapplication.App.isNetworkAvailable;

public class ErrorHandling {

    public static void isnotSuccessful(int code, String message, Context context) {
        switch (code) {
            case 401:
                Toast.makeText(context, "Authorization error", Toast.LENGTH_SHORT).show();
                break;
            case 400:
                Toast.makeText(context, "Bad request", Toast.LENGTH_SHORT).show();
                break;
            case 404:
                Toast.makeText(context, "Server not found", Toast.LENGTH_SHORT).show();
                break;
            case 409:
                Toast.makeText(context, "Sql error", Toast.LENGTH_SHORT).show();
                break;
            case 500:
                Toast.makeText(context, "Server broken", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public static void serverError(String message, Context context) {

        if(isNetworkAvailable()){
            Toast.makeText(context, "server error try again later",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "No Internet Connection !",Toast.LENGTH_SHORT).show();
        }

    }
}
