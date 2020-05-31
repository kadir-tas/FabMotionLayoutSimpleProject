package com.simple.fabmotionlayoutsimpleproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BannerAdapter extends RecyclerView.Adapter {

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

    public BannerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.item_list_main, viewGroup, false);
        return new BannerViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int resourceId = images[position];
        ((BannerViewHolder)holder).getmDataImgView().setImageResource(resourceId);
    }

    @Override
    public int getItemCount() {
        if(images == null)
            return 0;
        return images.length;
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mDataImgView;

        public BannerViewHolder(View v) {
            super(v);
            mDataImgView = v.findViewById(R.id.imageViewCover);
        }

        public ImageView getmDataImgView() {
            return mDataImgView;
        }
    }
}
