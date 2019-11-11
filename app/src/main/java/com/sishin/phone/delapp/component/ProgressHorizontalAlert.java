package com.sishin.phone.delapp.component;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

import com.sishin.phone.delapp.R;

import androidx.appcompat.app.AlertDialog;

public class ProgressHorizontalAlert {
    private Context mContext = null;
    private View mRootView = null;
    private AlertDialog.Builder mAlertBuilder = null;
    public AlertDialog mAlertDialog = null;
    private ProgressBar mProgressBar = null;

    public ProgressHorizontalAlert(Context context){
        this.mContext = context;
        mAlertBuilder = new AlertDialog.Builder(context);
        mRootView = ((Activity)mContext).getLayoutInflater().inflate(R.layout.custom_progress_dlg_h, null);
        mProgressBar = mRootView.findViewById(R.id.progress_custom_h);

        mAlertBuilder.setView(mRootView);
        mAlertBuilder.setCancelable(false);
        mAlertDialog = mAlertBuilder.show();
    }

    public void setProgress(int progress){
        mProgressBar.setProgress(progress);
    }

    public void setMax(int max){
        mProgressBar.setMax(max);
    }

    public void dismiss(){
        mAlertDialog.dismiss();
    }

}
