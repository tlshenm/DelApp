package com.sishin.phone.delapp.component;

import android.app.ProgressDialog;
import android.content.Context;

public class CustomProgressDialog {

    private Context mContext = null;
    private PROGRESS_TYPE mType = null;
    protected ProgressDialog mProgressDialog = null;

    public enum PROGRESS_TYPE {
        CIRCLE, HORIZONTAL, NONE
    }

    public CustomProgressDialog(Context context) {
        this.mContext = context;
        this.mType = PROGRESS_TYPE.CIRCLE;
    }

    public CustomProgressDialog(Context context,PROGRESS_TYPE progress_type) {
        this.mContext = context;
        this.mType = progress_type;
    }


    public void showProgressDialog() {
        switch (mType) {
            case CIRCLE:
                showCircleProgressDialog();
                break;
            case HORIZONTAL:
                showHorizontalProgressDialog();
                break;
            case NONE:
                break;
        }
    }


    /**
     * 프로그래스를 보여준다.
     */
    public void showHorizontalProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(mContext);
            mProgressDialog.setMessage("로딩중");
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setProgress(0);
            mProgressDialog.setCancelable(false);
        }
        mProgressDialog.show();
    }

    /**
     * 프로그래스를 보여준다.
     */
    public void showCircleProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(mContext);
            mProgressDialog.setMessage("로딩중");
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setCancelable(false);
        }
        mProgressDialog.show();
    }

    public void setProgress(int i) {
        mProgressDialog.setProgress(i);
    }

    /**
     * 프로그래스를 숨긴다.
     */
    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    public void setMax(int max) {
        mProgressDialog.setMax(max);
    }
}
