package com.example.samrudhinayak.app2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Samrudhi Nayak on 3/10/2016.
 */

//receiver of the broadcast message from first App
public class IndianapolisReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "You have selected Indianapolis Receiver! ",
                Toast.LENGTH_LONG).show() ;
        System.out.println("You have reached Indianapolis!");
        Intent myintent =new Intent(context,IndianapolisMainActivity.class);
        myintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //opens the main activity of Indianapolis
        context.startActivity(myintent);
    }
}