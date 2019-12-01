package com.sishin.phone.delapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sishin.phone.delapp.appFragment.OnListFragmentInteractionListener;
import com.sishin.phone.delapp.data.AppData;
import com.sishin.phone.delapp.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class appRecyclerViewAdapter extends RecyclerView.Adapter<appRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<AppData> mValues;
    private final OnListFragmentInteractionListener mListener;

    public appRecyclerViewAdapter(ArrayList<AppData> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_app, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIvApp.setBackground(mValues.get(position).icon);
        holder.mTvAppName.setText(mValues.get(position).title);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void clear(){
        mValues.clear();
    }

    public void addAll(ArrayList<AppData> mAppList){
        mValues.addAll(mAppList);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mIvApp;
        public final TextView mTvAppName;
        public AppData mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIvApp = (ImageView) view.findViewById(R.id.iv_app_list);
            mTvAppName = (TextView) view.findViewById(R.id.tv_app_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTvAppName.getText() + "'";
        }
    }
}
