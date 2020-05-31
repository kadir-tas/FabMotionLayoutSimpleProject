package com.simple.fabmotionlayoutsimpleproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.simple.fabmotionlayoutsimpleproject.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements AddPlantClick{

    private static final String TAG = "MainActivity";
    private BannerAdapter mBannerAdapter;
    private PlantAdapter mPlantAdapter;

    private RecyclerView mBannerRecyclerView;
    private RecyclerView mPlantsRecyclerView;

    ActivityMainBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main, null);
        dataBinding.waitScreen.setVisibility(View.VISIBLE);
        dataBinding.content.wrapper.setAddPlantClick(this);
        dataBinding.content.wrapper.bottomAppbar.setNavigationOnClickListener(v -> dataBinding.main.openDrawer(Gravity.LEFT));
        initBannerRecyclerView();
        initPlantRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    /**
     * Init main banners recyclerview
     */
    private void initBannerRecyclerView() {
        mBannerRecyclerView = dataBinding.content.wrapper.recyclerView;
        mBannerRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mBannerRecyclerView);
        mBannerRecyclerView.setHasFixedSize(true);

        mBannerAdapter = new BannerAdapter(this);
        mBannerRecyclerView.setAdapter(mBannerAdapter);
        dataBinding.waitScreen.setVisibility(View.INVISIBLE);
    }

    /**
     * Init Main user plants recyclerview
     */
    private void initPlantRecyclerView() {

        mPlantsRecyclerView = dataBinding.content.wrapper.plantRecyclerView.plantRecyclerView;
        mPlantsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mPlantsRecyclerView);
        mPlantsRecyclerView.setHasFixedSize(true);

        //Keeping the last item position to manage the onclick of the plant. See onPlantClick to understand this logic
        mPlantsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                View v = snapHelper.findSnapView(recyclerView.getLayoutManager());

                if(dataBinding.content.wrapper.motionLayout.getProgress() < 0.3){
                    recyclerView.smoothScrollToPosition(0);
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        mPlantAdapter = new PlantAdapter(this);
        mPlantsRecyclerView.setAdapter(mPlantAdapter);
    }


    @Override
    public void onAddPlantClick() {
        startActivity(new Intent(MainActivity.this, PlantCategoryActivity.class));
        finish();
    }

}

