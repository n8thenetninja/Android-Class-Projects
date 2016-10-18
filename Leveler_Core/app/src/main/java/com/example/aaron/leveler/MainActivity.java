package com.example.aaron.leveler;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor tilt;
    private ImageView head;
    //RelativeLayout relativeLayout = new RelativeLayout(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        head = (ImageView) findViewById(R.id.head);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);


        tilt = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {

        // 3 values, one for each axis.
        float xTilt = event.values[0];
        float yTilt = event.values[1];
        float zTilt = event.values[2];
        // Do something with this sensor value.
        showTilt(xTilt, yTilt);
        Log.d("Sensor Changed", String.format("x = %8.6f,  y = %8.6f,  z = %8.6f",xTilt, yTilt, zTilt));
    }

    public void showTilt(float hTilt, float vTilt) {
        int width;
        int height;

        width = (int)hTilt*100+50;
        height = Math.abs((int)vTilt*100);

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(200,200);
        lp.setMargins(width,height,1,1);
        // ViewGroup.LayoutParams params = head.getLayoutParams();
        head.setLayoutParams(lp);
        //LinearLayout.MarginLayoutParams params = new LinearLayout.MarginLayoutParams();
        //params.

        //ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(width,height);
        //head.getLayoutParams().height = height;
        //head.getLayoutParams().width = width;
        //head.setLayoutParams(params);
        //top.setText("" + vTilt);
        //bottom.setText("" + -vTilt);
        //left.setText("" + -hTilt);
        //right.setText("" + hTilt);
/*
        int red = Math.abs((int)(hTilt*25.5));
        int blue = Math.abs((int)(vTilt*25.5));
        int green = Math.abs((int)(lTilt*25.5));

        top.setText("red: " + red + "\nblue: " + blue + "\ngreen: " + green);

        gridLayout.setBackgroundColor(Color.rgb(red,green,blue));

        if (green>225) {
            bottom.setText("You have no chance. Make your time!");
        }
        else {
            bottom.setText("All your base are belong to us.");
        }

    */
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, tilt,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
