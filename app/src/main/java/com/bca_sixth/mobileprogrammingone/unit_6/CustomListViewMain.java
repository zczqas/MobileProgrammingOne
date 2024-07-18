package com.bca_sixth.mobileprogrammingone.unit_6;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bca_sixth.mobileprogrammingone.R;

public class CustomListViewMain extends AppCompatActivity {
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
        setContentView(R.layout.unit_6_listview);

        Resources res = getResources();

        ListView listView = findViewById(R.id.listViewMain);
        ViewGroup rootLayout = findViewById(R.id.listViewMainLayout);

        String[] titleList = res.getStringArray(R.array.f1_drivers_list);
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

        CustomListItem customAdapter = new CustomListItem(this, imageList, titleList, descriptionList);

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String close = "Okay!";
                Adapter listAdapter = parent.getAdapter();
                String value = listAdapter.getItem(position).toString();
                String message = value + " is selected " + position + " with id " + id;

                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
