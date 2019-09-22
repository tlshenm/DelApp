package com.sishin.phone.delapp.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.sishin.phone.delapp.R;
import com.sishin.phone.delapp.appFragment;
import com.sishin.phone.delapp.data.AppData;
import com.sishin.phone.delapp.dummy.DummyContent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements appFragment.OnListFragmentInteractionListener {


    private LinearLayout mLlRoot = null;
    private appFragment mAppFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLlRoot = (LinearLayout) findViewById(R.id.ll_root);

//        testtest();
        fragmentDelete();
    }

    private void fragmentDelete(){
        if (mAppFragment == null || mAppFragment.isRemoving()) {
            mAppFragment = mAppFragment.newInstance(4);
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(android.R.id.content, mAppFragment);
        transaction.commit();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        //리스트 클릭
    }

//    private void testtest() {
//
//        for(int i=0;i<mAppList.size();i++){
//            TextView textView = new TextView(this);
//            textView.setText(mAppList.get(i).title);
//            textView.setPadding(0,10,0,0);
//            mLlRoot.addView(textView);
//
//            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(150,150);
//            ImageView imageView = new ImageView(this);
//            imageView.setBackground(mAppList.get(i).icon);
//            mLlRoot.addView(imageView,lp);
//        }
//
//        if (mAppFragment == null || mAppFragment.isRemoving()) {
//            mAppFragment = mAppFragment.newInstance(4);
//        }
//
//
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(android.R.id.content, mAppFragment);
//        transaction.commit();
//    }
}
