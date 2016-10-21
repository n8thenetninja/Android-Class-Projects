package com.example.nate.listofanimals;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AnimalDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);
        addFragment();
    }

    private void addFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        AnimalViewFragment animalViewFragment = new AnimalViewFragment();
        fragmentTransaction.add(R.id.animal_container, animalViewFragment, "ANIMAL_VIEW_FRAGMENT");
        setTitle("Animal Description");
        fragmentTransaction.commit();
    }
}
