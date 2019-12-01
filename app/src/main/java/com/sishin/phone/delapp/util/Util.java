package com.sishin.phone.delapp.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import java.util.List;

import static android.content.Context.ACTIVITY_SERVICE;

public class Util {

    /**
     * 앱제거 실행 소스
     * @param context
     * @param packageName
     */
    public static void goDeleteApp(Context context,String packageName) {
        Uri packageURI = Uri.parse("package:" + packageName);
        Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(uninstallIntent);
    }
    
}
