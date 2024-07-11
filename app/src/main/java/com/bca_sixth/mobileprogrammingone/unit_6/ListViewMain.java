package com.bca_sixth.mobileprogrammingone.unit_6;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bca_sixth.mobileprogrammingone.R;

public class ListViewMain extends AppCompatActivity {
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

        String[] warhammerList = res.getStringArray(R.array.warhammer_list);
        ArrayAdapter<String> warhammerAdapter = new ArrayAdapter<>(
                this,
                R.layout.unit_3_spinner_item,
                R.id.spinner_item_text,
                warhammerList
        );

        listView.setAdapter(warhammerAdapter);

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
