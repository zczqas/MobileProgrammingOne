package com.bca_sixth.mobileprogrammingone.unit_6;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bca_sixth.mobileprogrammingone.R;

public class GridViewMain extends AppCompatActivity {
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
        setContentView(R.layout.unit_6_grid_view_main);

        Resources res = getResources();

        GridView gridView = findViewById(R.id.gridViewMainList);
        ViewGroup rootLayout = findViewById(R.id.gridViewMainRoot);

        String[] driverList = res.getStringArray(R.array.f1_drivers_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.unit_3_spinner_item,
                R.id.spinner_item_text,
                driverList
        );

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String close = "Okay!";
                Adapter gridAdapter = parent.getAdapter();
                String value = gridAdapter.getItem(position).toString();
                String message = value + " is selected " + position + " with id " + id;

                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
