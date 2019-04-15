package com.smart.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.smart.myapplication.R;
import com.smart.myapplication.activities.MachineActivity;
import com.smart.myapplication.model.machinedetail.Asset;
import com.smart.myapplication.model.machinedetail.Image;

import java.util.ArrayList;
import java.util.List;

public class MachinesListAdapter extends RecyclerView.Adapter<MachinesListAdapter.ViewHolder> {

    private Context mContext;
    List<Asset> mAssets;

    public MachinesListAdapter(MachineActivity machineActivity, List<Asset> assets) {
        Log.d("sarath", "MachinesListAdapter: " + assets.size());
        mContext = machineActivity;
        this.mAssets = assets;
    }

    @NonNull
    @Override
    public MachinesListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.machineslist, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MachinesListAdapter.ViewHolder viewHolder, int i) {
        Asset asset = mAssets.get(i);
        viewHolder.tvMachinename.setText(asset.getName());
        Image image1 = asset.getImage();

        Log.d("sarath", "onBindViewHolder: "+image1);
        Glide.with(mContext).load(image1.getSmallUrl())
                .thumbnail(0.5f)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.ivImage);

    }

    @Override
    public int getItemCount() {
        Log.d("sarath", "getItemCount: " + mAssets.size());
        return mAssets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvMachinename;
        ImageView ivImage;

        public ViewHolder(View itemView) {
            super(itemView);
            tvMachinename = itemView.findViewById(R.id.machineName);
            ivImage = itemView.findViewById(R.id.image);

        }
    }
}
