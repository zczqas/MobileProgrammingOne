package com.bca_sixth.mobileprogrammingone.unit_5;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bca_sixth.mobileprogrammingone.R;

public class FragmentSwitchActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.unit_5_fragment_switch);

        FragmentManager fm = getSupportFragmentManager();
        int fragmentContainerId = R.id.fragment_container_view;
        Button button_fragment_one = findViewById(R.id.button_fragment_one);
        Button button_fragment_two = findViewById(R.id.button_fragment_two);
        Button button_x = findViewById(R.id.button_x);

        button_fragment_one.setOnClickListener(v -> {
            Fragment fragment_one = new KittyFragment();

            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(fragmentContainerId, fragment_one);
            transaction.addToBackStack(null);
            transaction.commit();
        });

        button_fragment_two.setOnClickListener(v -> {
            Fragment fragment_two = new GengarFragment();
            Fragment fragment_text = new TextFragment();

            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(fragmentContainerId, fragment_two);
            transaction.add(fragmentContainerId, fragment_text);
            transaction.addToBackStack(null);
            transaction.commit();
        });

        button_x.setOnClickListener(v -> {
            fm.popBackStack();
        });
    }
}

