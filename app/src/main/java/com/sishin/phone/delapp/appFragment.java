package com.sishin.phone.delapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.sishin.phone.delapp.data.AppData;
import com.sishin.phone.delapp.dummy.DummyContent;
import com.sishin.phone.delapp.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class appFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 4;
    private OnListFragmentInteractionListener mListener;
    private ArrayList<AppData> mAppList = null;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public appFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static appFragment newInstance(int columnCount) {
        appFragment fragment = new appFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_app_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new appRecyclerViewAdapter(DummyContent.ITEMS, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }

    private class AppListTask extends AsyncTask<Void,Integer,ArrayList<AppData>>{
        private ProgressDialog mProgressDialog = null;



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if(mAppList==null){
                mAppList = new ArrayList<>();
            }
            mAppList.clear();

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<AppData> doInBackground(Void... strings) {

            PackageManager pkgMgr = getContext().getPackageManager();
            List<ResolveInfo> apps = null;
            ArrayList<AppData> appList = new ArrayList<AppData>();

            Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
            mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            apps = pkgMgr.queryIntentActivities(mainIntent, 0); // 실행가능한 Package만 추출.
            if (apps != null && 0 < apps.size()) {
                Collections.sort(apps, new ResolveInfo.DisplayNameComparator(pkgMgr));
                for (int i = 0; i < apps.size(); i++) {
                    AppData appData = new AppData();

                    appData.title = apps.get(i).activityInfo.loadLabel(pkgMgr).toString();
                    appData.icon = apps.get(i).loadIcon(getContext().getPackageManager());
                    appData.packageName = apps.get(i).activityInfo.packageName;
                    appList.add(appData);

                }
                return appList;
            } else {
                return null;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<AppData> appList) {
            super.onPostExecute(appList);
            if(appList != null){
                mAppList = appList;
            }else{
                //Todo 에러발생 알림적용
            }
        }
    }

}
