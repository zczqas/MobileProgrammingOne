package com.bca_sixth.mobileprogrammingone.unit_2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bca_sixth.mobileprogrammingone.R;

public class Unit_2 extends Activity {
    private Button submit_button;
    private TextView heading_text;
    private EditText edit_text;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.unit_2_hello);

        heading_text = findViewById(R.id.heading_text);
        submit_button = findViewById(R.id.submit_button);
        edit_text = findViewById(R.id.edit_text);

        submit_button.setOnClickListener(v -> {
            String input_value = edit_text.getText().toString();

            if (input_value.isEmpty()) {
                heading_text.setText("Empty! Why!!");
            } else {
                heading_text.setText(input_value);
            }
        });
    }


}
