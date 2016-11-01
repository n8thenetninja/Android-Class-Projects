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

    // String ids for passing data to the array adapter
    public static final String ANIMAL_DESCRIPTION_EXTRA = "com.example.nate.listofanimals.Animal Description";
    public static final String ANIMAL_CATEGORY_EXTRA = "com.example.nate.listofanimals.Animal Category";
    public static final String ANIMAL_CATEGORY_STRING_EXTRA = "com.example.nate.listofanimals.Animal CategoryString";

    public static final String ANIMAL_NAME_EXTRA = "com.example.nate.listofanimals.Animal Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
