package com.example.nate.listofanimals;
/*
* Project written for Mobile Devices Programming class,
* Prof, Aaron Gordon
*
* Author: Nathan Larson
*
* References: Thanks to TutorialBaba YouTube Channel section on fragments and
*             custom Array Adapters
*
* */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    public static final String ANIMAL_ID_EXTRA = "com.example.nate.listofanimals.Animal Identifyer";
    public static final String ANIMAL_NAME_EXTRA = "com.example.nate.listofanimals.Animal Name";
    public static final String ANIMAL_DESCRIPTION_EXTRA = "com.example.nate.listofanimals.Animal Description";
    public static final String ANIMAL_CATEGORY_EXTRA = "com.example.nate.listofanimals.Animal Category";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
