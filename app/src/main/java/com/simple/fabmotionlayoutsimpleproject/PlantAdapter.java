package com.simple.fabmotionlayoutsimpleproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PlantAdapter extends BaseAdapter<PlantAdapter.BannerViewHolder, Banner> {
    private static final String TAG = "PlantAdapter";
    private Context context;


    int[] images = new int[]{
            R.drawable.fruits,
            R.drawable.baked_goods1,
            R.drawable.snacks,
            R.drawable.ice_cream,
            R.drawable.ready_to_eat,
            R.drawable.drinks,
            R.drawable.fit_food,
            R.drawable.daily,
            R.drawable.food,
            R.drawable.personal_care,
            R.drawable.home_care,
            R.drawable.home_living1,
            R.drawable.tech,
            R.drawable.pet_care1,
            R.drawable.baby_care,
            R.drawable.sex_health,
            R.drawable.apparel
    };

    public PlantAdapter(Context context) {
        this.context = context;
    }

    @Override
    public void setData(List<Banner> banners) {
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlantAdapter.BannerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item_rv_plant_main, viewGroup, false);
        return new PlantAdapter.BannerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantAdapter.BannerViewHolder holder, int position) {
        int resourceId = images[position];
        Log.d(TAG, "onBindViewHolder: " + position + "   " + resourceId);
        Log.d(TAG, "onBindViewHolder: " + holder + "   " + holder.getmDataImgView());
        holder.getmDataImgView().setImageResource(resourceId);
    }

    @Override
    public int getItemCount() {
        if (images == null)
            return 0;
        return images.length;
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        private ImageView mDataImgView;

        public BannerViewHolder(View v) {
            super(v);
            Log.d(TAG, "BannerViewHolder: " + "HERE" + mDataImgView);
            mDataImgView = v.findViewById(R.id.image);
            Log.d(TAG, "BannerViewHolder: " + "HERE2" + mDataImgView);
        }

        ImageView getmDataImgView() {
            return mDataImgView;
        }
    }
}