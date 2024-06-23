package com.bca_sixth.mobileprogrammingone.unit_4;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bca_sixth.mobileprogrammingone.R;

import java.util.ArrayList;

public class About extends Activity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.unit_4_about);

        Log.d("myStateLog", "About - onCreate");

        Resources res = getResources();

        Intent i = getIntent();

        String gender = i.getStringExtra("gender");
        String country = i.getStringExtra("country");
        String fullName = i.getStringExtra("fullName");
        ArrayList<String> sports = i.getStringArrayListExtra("sports");

        View rootLayout = findViewById(R.id.aboutRoot);
        Button backButton = findViewById(R.id.aboutBackButton);
        TextView sportsText = findViewById(R.id.aboutSportsValue);
        TextView genderText = findViewById(R.id.aboutGenderValue);
        Button dialogButton = findViewById(R.id.aboutDialogButton);
        TextView countryText = findViewById(R.id.aboutCountryValue);
        TextView fullNameText = findViewById(R.id.aboutFullNameValue);
//        ImageButton profileIconButton = findViewById(R.id.aboutProfileIconButton);

        backButton.setOnClickListener(v -> finish());

        dialogButton.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Dialog", Toast.LENGTH_SHORT).show());

        genderText.setText(gender);
        countryText.setText(country);
        if (fullName != null && !fullName.isEmpty()) fullNameText.setText(fullName);
        else fullNameText.setText("N/A");

        if (sports != null && !sports.isEmpty()) {
            String joinedSports = String.join(", ", sports);
            sportsText.setText(joinedSports);
        } else {
            Toast.makeText(getApplicationContext(), "No sports", Toast.LENGTH_SHORT).show();
            sportsText.setText("N/A");
        }

//        Button cancelButton = findViewById(R.id.cancelButton);
//        Button submitButton = findViewById(R.id.submitButton);
//
//        cancelButton.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_SHORT).show());
//
//        submitButton.setOnClickListener(v -> Toast.makeText(getApplicationContext(), "Submitted", Toast.LENGTH_SHORT).show());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("myStateLog", "About - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("myStateLog", "About - onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("myStateLog", "About - onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("myStateLog", "About - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("myStateLog", "About - onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("myStateLog", "About - onDestroy");
    }
}