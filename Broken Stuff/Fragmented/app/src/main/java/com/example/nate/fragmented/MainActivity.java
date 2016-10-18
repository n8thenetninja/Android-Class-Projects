package com.example.nate.fragmented;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import layout.Frag1;

public class MainActivity extends AppCompatActivity {
    boolean status = false;
    Button fragsbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragsbutton = (Button) findViewById(R.id.fragsbutton);
        fragsbutton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                android.app.FragmentManager fragmentManager = getFragmentManager();
                android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if (!status) {
                    Frag1 f1 = new Frag1();
                    fragmentTransaction.add(R.id.frags,f1);
                    fragmentTransaction.commit();
                    fragsbutton.setText("Frag2");
                }
            }
        });


    }

}
