package com.sishin.phone.delapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.sishin.phone.delapp.util.Util;

public class PackageReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_PACKAGE_REMOVED)){
            if(Util.currentViewApp(context)) {
                Log.v("sishin", "sishin data : " + intent.getData());

                /*삭제완료 리시버*/
                Toast.makeText(context, "삭제완료!!!", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "다른곳에서 삭제완료!!!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
