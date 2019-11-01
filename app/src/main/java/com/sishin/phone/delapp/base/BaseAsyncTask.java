package com.sishin.phone.delapp.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

/**
 * AsyncTask 부모 클래스
 */
public abstract class BaseAsyncTask<T, T1, T2> extends AsyncTask<T, T1, T2> {
    protected ProgressDialog mProgressDialog = null;
    private Context mContext = null;

    public BaseAsyncTask(Context context){
        this.mContext = context;
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


    /**
     * 프로그래스를 숨긴다.
     */
    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(T2 t2) {
        super.onPostExecute(t2);
        hideProgressDialog();
    }
}
