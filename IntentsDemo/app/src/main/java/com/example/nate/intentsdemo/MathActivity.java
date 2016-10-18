package com.example.nate.intentsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        // Get the intent that started us to find a parameter (extra)
        Intent intent = getIntent();
        int myValue = intent.getIntExtra("Parameter name", 0);
        // Display the value to the screen
        TextView displayNumber = (TextView) findViewById(R.id.textViewUsersNumber);
        displayNumber.setText("" + myValue);
    }
}
