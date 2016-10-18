package com.example.nate.colorgrabber;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button getColor1;
    Button getColor2;
    SeekBar slider;
    TextView colorView;
    TextView colorDisplayNum;

    int color1 = 510;
    int color2 = 255;
    int mixedColor;



    //Intent intent = new Intent(Intent.ACTION_VIEW,
      //      Uri.parse("msud.cs3013.ACTION_COLOR"));




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        getColor1 = (Button) findViewById(R.id.getColor1);
        getColor2 = (Button) findViewById(R.id.getColor2);
        slider = (SeekBar) findViewById(R.id.slider);
        colorView = (TextView) findViewById(R.id.color);
        colorDisplayNum = (TextView) findViewById(R.id.colorDisplayNum);

        //Intent intent = getIntent();
        //colorSpace = intent.getIntExtra("Parameter name", 0);

        //final Intent intent = new Intent();
        //intent.setClassName("com.example.nate.colorpicker", "com.example.nate.colorpicker.MainActivity");

        getColor1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Intent intent = new Intent("msud.cs3013.ACTION_COLOR");
                //Intent intent = new Intent();
                //intent.setClassName("com.example.nate.colorpicker", "com.example.nate.colorpicker.MainActivity");

                //startActivityForResult(intent, 1);

                //color1 = intent.getIntExtra("Parameter name", 0);

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setClassName("com.example.nate.colorpicker", "com.example.nate.colorpicker.MainActivity");

                startActivityForResult(intent,1);


            }
        });
        //color1 = intent.getIntExtra("Parameter name", 0);

        getColor2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Intent intent = new Intent("msud.cs3013.ACTION_COLOR");
                //Intent intent = new Intent();
                //intent.setClassName("com.example.nate.colorpicker", "com.example.nate.colorpicker.MainActivity");

                //startActivityForResult(intent, 1);

                //color2 = intent.getIntExtra("Parameter name", 0);
                //startActivityForResult(intent, 1);

                //color2 = intent.getIntExtra("Parameter name", 0);
                //colorView.setBackgroundColor(Color.rgb(mixedColor&0xFF0000<<16,mixedColor&0x00ff00<<8,mixedColor&0x0000FF));
                //Intent intent = new Intent();
                //intent.setClassName("com.example.nate.colorpicker", "com.example.nate.colorpicker.MainActivity");

                //startActivity(intent);
                //color2 = colorSpace;
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setClassName("com.example.nate.colorpicker", "com.example.nate.colorpicker.MainActivity");

                startActivityForResult(intent,2);
            }
        });
        //color2 = intent.getIntExtra("Parameter name", 0);
        slider.setMax(99);
        slider.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //int redValue;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        int color1Percent = progress+1;
                        int color2Percent = (100 - progress);
                        int color1Red = color1>>16;
                        int color1Green = (color1>>8)&0xff;
                        int color1Blue = color1&0xFF;
                        int color2Red = color2>>16;
                        int color2Green = (color2>>8)&0xff;
                        int color2Blue = color2&0xff;
                        int blendRed = (color1Red*color1Percent + color2Red*color2Percent)/100;
                        int blendBlue = (color1Blue*color1Percent + color2Blue*color2Percent)/100;
                        int blendGreen = (color1Green*color1Percent + color2Green*color2Percent)/100;

                        mixedColor = Color.rgb(blendRed,blendGreen,blendBlue);
                        //colorView.setBackgroundColor(color1);
                        colorView.setBackgroundColor(mixedColor);
                        colorDisplayNum.setText(Integer.toHexString(mixedColor));

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        colorView.setBackgroundColor(mixedColor);
                        //colorView.setBackgroundColor(Color.red(color1));
                        colorDisplayNum.setText(Integer.toHexString(mixedColor));

                    }
                }
        );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("colorBlender", "onActivityResult");
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            color1 = data.getIntExtra("color", 0);
        }
        else if (requestCode == 2) {
            color2 = data.getIntExtra("color",0);
        }

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
