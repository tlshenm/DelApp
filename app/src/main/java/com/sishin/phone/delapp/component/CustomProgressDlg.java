package com.sishin.phone.delapp.component;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AlertDialog;

import com.sishin.phone.delapp.R;

public class CustomProgressDlg {
    private Context mContext = null;
    private View mRootView = null;
    private AlertDialog.Builder mAlertBuilder = null;
    private AlertDialog mAlertDialog = null;

    public enum DIALOG_TYPE {
        CIRCLE, HORIZONTAL
    }
    private ProgressBar mProgressBar = null;


    public CustomProgressDlg(Context context) {
        mContext = context;
        mAlertBuilder = new AlertDialog.Builder(context);
        mRootView = ((Activity)mContext).getLayoutInflater().inflate(R.layout.custom_progress_dlg, null);
        mProgressBar = (ProgressBar)mRootView.findViewById(R.id.progress_h);
    }

    public AlertDialog.Builder setMessage(String msg){
        return mAlertBuilder.setMessage(msg);
    }

    public AlertDialog.Builder setMessage(int msg){
        return mAlertBuilder.setMessage(msg);
    }

    public void setMax(int max){
        mProgressBar.setMax(max);
    }

    /**
     * true 작업이 언제 완료될지  알 수 없는 경우(Circle)
     *
     * false 작업이 완료를 수치적으로 표시할때(Horizontal)
     * @param bool
     */
    public void setIndeterminate(boolean bool){
        mProgressBar.setIndeterminate(bool);
    }

    public void setProgress(int i){
        mProgressBar.setProgress(i);
    }

    public void showDialog(){
        mAlertDialog = mAlertBuilder.show();
    }

    public void hideDialog(){
        if(mContext != null && !((Activity)mContext).isFinishing()){
            mAlertDialog.dismiss();
        }
    }

}
