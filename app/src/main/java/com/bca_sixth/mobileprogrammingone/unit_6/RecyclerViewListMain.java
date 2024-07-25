package com.bca_sixth.mobileprogrammingone.unit_6;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bca_sixth.mobileprogrammingone.R;

import java.util.ArrayList;

public class RecyclerViewListMain extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();

        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.unit_6_recycler_view_list_main);

        Resources res = getResources();

        ArrayList<DriverDetail> driverList = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        String[] titleList = res.getStringArray(R.array.f1_drivers_list);
//        String[] teamList = res.getStringArray(R.array.f1_teams_list);
        String[] descriptionList = res.getStringArray(R.array.f1_drivers_description);
        int[] imageList = {
                R.drawable.dice,
                R.drawable.dice,
                R.drawable.dice,
                R.drawable.dice,
                R.drawable.dice,
                R.drawable.dice,
                R.drawable.dice,
                R.drawable.dice,
                R.drawable.dice,
                R.drawable.dice,
                R.drawable.dice,
                R.drawable.dice,
                R.drawable.dice,
                R.drawable.dice,
                R.drawable.dice,
                R.drawable.dice,
                R.drawable.dice,
                R.drawable.dice,
                R.drawable.dice,
                R.drawable.dice,
        };

        for (int i = 0; i < titleList.length; i++) {
            driverList.add(new DriverDetail(imageList[i], titleList[i], descriptionList[i]));
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        CustomRecyclerViewListItem itemList = new CustomRecyclerViewListItem(this, driverList);

        recyclerView.setAdapter(itemList);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
