package com.wise.bottombar.sample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Vardhan on 3/6/2018.
 */

public class RestartService extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
       // Log.d("abc","broadcast");
        context.startService(new Intent(context,BlockServ.class));
    }
}
