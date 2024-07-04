package com.bca_sixth.mobileprogrammingone.unit_5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.bca_sixth.mobileprogrammingone.R;

import org.jetbrains.annotations.NotNull;

public class KittyFragment extends Fragment {
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle b) {
        return inflater.inflate(R.layout.unit_5_cat, container, false);
    }
}
