package com.bca_sixth.mobileprogrammingone.unit_4;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bca_sixth.mobileprogrammingone.R;
import com.bca_sixth.mobileprogrammingone.unit_6.CustomListViewMain;
import com.bca_sixth.mobileprogrammingone.unit_6.GridViewMain;
import com.bca_sixth.mobileprogrammingone.unit_6.ListViewMain;
import com.bca_sixth.mobileprogrammingone.unit_6.RecyclerViewListMain;
import com.bca_sixth.mobileprogrammingone.unit_7.UserProfileMain;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    private EditText edit_text;
    private RadioGroup genderGroup;
    private TextView heading_text;
    private Button menu_button;


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
        Button db_button = findViewById(R.id.db_button);
        menu_button = findViewById(R.id.menu_button);

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

        db_button.setOnClickListener(v -> {
            Intent i = new Intent(Home.this, UserProfileMain.class);
            startActivity(i);
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

        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.gruv_aqua));

        if (getSupportActionBar() != null) {
            ActionBar bar = getSupportActionBar();
            int color = ContextCompat.getColor(this, R.color.gruv_aqua);
            int textColor = ContextCompat.getColor(this, R.color.gruv_white);
            Spannable text = new SpannableString(getString(R.string.hello_world));

            text.setSpan(new ForegroundColorSpan(textColor), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            text.setSpan(new AbsoluteSizeSpan(20, true), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            text.setSpan(new LeadingMarginSpan.Standard(20), 0, text.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

            bar.setTitle(text);
            bar.setElevation(10);
            bar.setBackgroundDrawable(new ColorDrawable(color));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_options, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int selected_item = item.getItemId();

        if (selected_item == R.id.appOptionsServices) {
            Intent i = new Intent(Home.this, GridViewMain.class);
            startActivity(i);
            return true;
        }

        if (selected_item == R.id.appOptionsAbout) {
            Intent i = new Intent(Home.this, ListViewMain.class);
            startActivity(i);
            return true;
        }

        if (selected_item == R.id.appOptionsTheme) {
            Intent i = new Intent(Home.this, CustomListViewMain.class);
            startActivity(i);
            return true;
        }

        if (selected_item == R.id.appOptionsExit) {
            Intent i = new Intent(Home.this, RecyclerViewListMain.class);
            startActivity(i);
            return true;
        }

        return false;
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.app_options, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        return super.onContextItemSelected(item);
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("my_state", "HomePage - onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Log.d("my_state", "HomePage - onResume");
//        Toast.makeText(getApplicationContext(), "Resumed", Toast.LENGTH_SHORT).show();
        registerForContextMenu(menu_button);
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
