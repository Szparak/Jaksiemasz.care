package com.example.pernal.jaksiemaszcare;

import android.content.Context;
import android.widget.Toast;


/**
 * Created by pernal on 15.11.17.
 */

class Helper {

    public static void makeAndShowToast(String message, Context context){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}