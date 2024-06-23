package com.bca_sixth.mobileprogrammingone.unit_4;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bca_sixth.mobileprogrammingone.R;

import java.util.ArrayList;

public class Home extends Activity {
    private EditText edit_text;
    private RadioGroup genderGroup;
    private TextView heading_text;

    @Override
    public void onCreate(android.os.Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.unit_3_constraint);

        Log.d("my_state", "HomePage - onCreate");

        Spinner country_spinner = findViewById(R.id.country_spinner);
        String[] country_list = {"Nepal", "India", "United States", "China", "Japan", "France"};

        ArrayAdapter<String> country_adapter = new ArrayAdapter<>(
                this,
                R.layout.unit_3_spinner_item,
                country_list
        );
        country_spinner.setAdapter(country_adapter);

        heading_text = findViewById(R.id.heading_text);
        Button submit_button = findViewById(R.id.submit_button);
        Button cancel_button = findViewById(R.id.cancel_button);
        Button activity_button = findViewById(R.id.activity_button);

        genderGroup = findViewById(R.id.radioGroup);
        edit_text = findViewById(R.id.edit_text);

        CheckBox checkbox_football = findViewById(R.id.checkbox_football);
        CheckBox checkbox_basketball = findViewById(R.id.checkbox_basketball);
        CheckBox checkbox_cricket = findViewById(R.id.checkbox_cricket);
        CheckBox checkbox_judo = findViewById(R.id.checkbox_judo);

//        submit_button.setOnClickListener(v -> {
//            Intent i = new Intent(Home.this, About.class);
//
//            i.putExtra("gender", "Male");
//            i.putExtra("country", "Nepal");
//            i.putExtra("fullName", "Sanchar");
//
//            i.putStringArrayListExtra(
//                    "sports",
//                    new ArrayList<>(
//                            Arrays.asList(
//                                    "Football",
//                                    "Basketball",
//                                    "Tennis"
//                            )
//                    )
//            );
//
//            startActivity(i);
//        });

        submit_button.setOnClickListener(v -> {
            String selectGender = "N/A";
            Intent i = new Intent(Home.this, About.class);
            String fullName = edit_text.getText().toString();
            String selectedCountry = country_spinner.getSelectedItem().toString();

            int checkRadioButtonId = genderGroup.getCheckedRadioButtonId();

            if (checkRadioButtonId == R.id.radioMale) selectGender = "male";
            if (checkRadioButtonId == R.id.radioFemale) selectGender = "female";
            if (checkRadioButtonId == R.id.radioOther) selectGender = "other";

            i.putExtra("gender", selectGender);
            i.putExtra("country", selectedCountry);
            i.putExtra("fullName", fullName);

            ArrayList<String> selectedSports = new ArrayList<>();

            CheckBox[] checkboxes = {
                    checkbox_football,
                    checkbox_basketball,
                    checkbox_cricket,
                    checkbox_judo,
            };

            for (CheckBox checkbox : checkboxes) {
                if (checkbox.isChecked()) selectedSports.add(checkbox.getText().toString());
            }

            i.putExtra("sports", selectedSports);

            startActivity(i);
        });

        activity_button.setOnClickListener(v -> {
            Intent i = new Intent(Home.this, Contact.class);
            startActivityForResult(i, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("myStateLog", "Home - onActivityResult" + requestCode + " " + resultCode);
        Log.d("myStateLog", "Home - onActivityResult" + data.getStringExtra("contactData"));

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Log.d("myStateLog", "This is running");
            String message = data.getStringExtra("contactData");
            Log.d("myStateLog", "data from second" + message);
            heading_text.setText(message);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("my_state", "HomePage - onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("my_state", "HomePage - onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("my_state", "HomePage - onResume");
        Toast.makeText(getApplicationContext(), "Resumed", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("my_state", "HomePage - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("my_state", "HomePage - onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("my_state", "HomePage - onDestroy");
    }
}
