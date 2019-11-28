package com.sishin.phone.delapp.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.sishin.phone.delapp.component.CustomProgressDialog;

/**
 * AsyncTask 부모 클래스
 */
public abstract class BaseAsyncTask<T, T1, T2> extends AsyncTask<T, T1, T2> {
    protected CustomProgressDialog mProgressDialog = null;
    private Context mContext = null;

    public BaseAsyncTask(Context context) {
        this.mContext = context;
        mProgressDialog = new CustomProgressDialog(context);
    }

    public BaseAsyncTask(Context context, CustomProgressDialog.PROGRESS_TYPE type) {
        this.mContext = context;
        mProgressDialog = new CustomProgressDialog(context, type);
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressDialog.showProgressDialog();
    }

    @Override
    protected void onPostExecute(T2 t2) {
        super.onPostExecute(t2);
        mProgressDialog.hideProgressDialog();
    }
}
