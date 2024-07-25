package com.bca_sixth.mobileprogrammingone.unit_6;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bca_sixth.mobileprogrammingone.R;

import java.util.ArrayList;

public class CustomRecyclerViewListItem extends RecyclerView.Adapter<RecyclerItemHolder> {
    Activity ctx;
    ArrayList<DriverDetail> driverList;

    public CustomRecyclerViewListItem(Activity ctx, ArrayList<DriverDetail> driverList) {
        this.ctx = ctx;
        this.driverList = driverList;
    }

    @NonNull
    @Override
    public RecyclerItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        View listItem = layoutInflater.inflate(R.layout.unit_6_custom_list_item, parent, false);
        return new RecyclerItemHolder(
                listItem,
                R.id.customListItemRoot,
                R.id.customListItemTitle,
                R.id.customListItemImage,
                R.id.customListItemDescription
        );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerItemHolder holder, int position) {
        DriverDetail driver = driverList.get(position);

        holder.imageView.setImageResource(driver.getImage());
        holder.titleView.setText(driver.getName());
        holder.descriptionView.setText(driver.getDescription());

        holder.rootView.setOnClickListener(v -> {
            String close = "Let it go!";
            String message = driver.getName() + " is selected " + position;
            Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show();
        });

        holder.imageView.setOnClickListener(v -> {
            String close = "Circle";
            String message = driver.getName() + " is selected " + position;
            Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return driverList.size();
    }
}
