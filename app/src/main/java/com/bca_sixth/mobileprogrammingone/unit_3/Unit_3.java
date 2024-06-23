package com.bca_sixth.mobileprogrammingone.unit_3;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bca_sixth.mobileprogrammingone.R;
import com.google.android.material.snackbar.Snackbar;

public class Unit_3 extends Activity {
    private TextView heading_text;
    private EditText edit_text;

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
        edit_text = findViewById(R.id.edit_text);

        submit_button.setOnClickListener(v -> {
            String input_value = edit_text.getText().toString();

            if (input_value.isEmpty()) {
                heading_text.setText("Empty! Why!!");
            } else {
                heading_text.setText(input_value);
            }
        });

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Canceled", Toast.LENGTH_SHORT).show();
                Snackbar.make(findViewById(android.R.id.content), "Canceled", Snackbar.LENGTH_SHORT).show();
            }
        });
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

