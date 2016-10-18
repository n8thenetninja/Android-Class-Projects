//This app demonstrates various ways of animating movement and color change
//Written by Aaron Gordon - September, 2016

package com.example.aaron.drawing1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ChalkBoard cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RelativeLayout relativeLayout;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        relativeLayout = (RelativeLayout) findViewById(R.id.backgroundLayout);
        cb = new ChalkBoard(this);      //Attach ChalkBoard to the Activity
        if (relativeLayout != null ) {
            relativeLayout.addView(cb);
        }
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);  //Link to Button
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cb.wander();                    //when button clicked, do animation in ChalkBoard
            }
        });    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Set which animation to perform on next Button click
        int id = item.getItemId();

        switch (id) {
            case R.id.raw_animation:
                cb.setStyle(ChalkBoard.RAW);
                return true;
            case R.id.obj_animation:
                cb.setStyle(ChalkBoard.ANIMATOR);
                return true;
            case R.id.accelorate_animation:
                cb.setStyle(ChalkBoard.ACCELERATOR);
                return true;
            case R.id.decelorate_animation:
                cb.setStyle(ChalkBoard.DECELERATE);
                return true;
            case R.id.bounce_animation:
                cb.setStyle(ChalkBoard.BOUNCE);
                return true;
            case R.id.rotate_animation:
                cb.setStyle(ChalkBoard.ROTATE);
                return true;
            case R.id.moverotate_animation:
                cb.setStyle(ChalkBoard.MOVE_ROTATE);
                return true;
            case R.id.color_animation:
                cb.setStyle(ChalkBoard.COLOR_ACC);
                return true;
            case R.id.movecolor_animation:
                cb.setStyle(ChalkBoard.MOVE_RECOLOR);
                return true;
            case R.id.moverotatecolor_animation:
                cb.setStyle(ChalkBoard.MOVE_ROTATE_RECOLOR);
                return true;
            case R.id.action_settings:
                break;
            default: break;
        }

        return super.onOptionsItemSelected(item);
    }
}