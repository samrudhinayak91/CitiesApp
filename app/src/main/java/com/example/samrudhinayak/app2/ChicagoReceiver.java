package com.example.samrudhinayak.app2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Samrudhi Nayak on 3/10/2016.
 */

//receiver that receives the Chicago broadcast from previous App
public class ChicagoReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "You have selected Chicago Receiver! ",
                Toast.LENGTH_LONG).show() ;
        System.out.println("You have reached Chicago!");
        Intent myintent =new Intent(context,ChicagoMainActivity.class);
        myintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //opens the Chicago main activity
        context.startActivity(myintent);
    }
}
