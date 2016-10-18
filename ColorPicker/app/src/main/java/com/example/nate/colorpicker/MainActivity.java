package com.example.nate.colorpicker;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    SeekBar redSelect;
    SeekBar blueSelect;
    SeekBar greenSelect;
    TextView colorView;
    TextView hexView;
    Button returnColor;

    int redValue = 0;
    int blueValue = 0;
    int greenValue = 0;
    int hexValue = Color.rgb(redValue,blueValue,greenValue);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        redSelect = (SeekBar) findViewById(R.id.redSelect);
        blueSelect = (SeekBar) findViewById(R.id.blueSelect);
        greenSelect = (SeekBar) findViewById(R.id.greenSelect);
        colorView = (TextView) findViewById(R.id.color);
        hexView = (TextView) findViewById(R.id.hexValue);
        hexView.setText("#" + Integer.toHexString(hexValue));
        hexValue = Color.rgb(redValue,blueValue,greenValue);
        returnColor = (Button) findViewById(R.id.returnColor);

        //final Intent intent = getIntent();

        //Bundle info = intent.getExtras();
        //if (info != null) {
            // Retrieve vals with info.getBlah(...)
          //  intent.putExtra("color",hexValue);
        //}
      //final Intent intent = getIntent();

        returnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                //intent.setAction(Intent.ACTION_SEND);
                intent.putExtra("color", hexValue);
                //setResult(Activity.RESULT_OK);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        redSelect.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //int redValue;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        redValue = progress;
                        hexValue = Color.rgb(redValue,blueValue,greenValue);
                        colorView.setBackgroundColor(hexValue);
                        hexView.setText("#" + Integer.toHexString(hexValue));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        colorView.setBackgroundColor(Color.rgb(redValue,blueValue,greenValue));
                        hexView.setText("#" + Integer.toHexString(hexValue));
                    }
                }
        );

        blueSelect.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //int redValue;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        blueValue = progress;
                        hexValue = Color.rgb(redValue,blueValue,greenValue);
                        colorView.setBackgroundColor(hexValue);
                        hexView.setText("#" + Integer.toHexString(hexValue));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        colorView.setBackgroundColor(Color.rgb(redValue,blueValue,greenValue));
                        hexView.setText("#" + Integer.toHexString(hexValue));
                    }
                }
        );

        greenSelect.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //int redValue;
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        greenValue = progress;
                        hexValue = Color.rgb(redValue,blueValue,greenValue);
                        colorView.setBackgroundColor(hexValue);
                        hexView.setText("#" + Integer.toHexString(hexValue));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        colorView.setBackgroundColor(Color.rgb(redValue,blueValue,greenValue));
                        hexView.setText("#" + Integer.toHexString(hexValue));
                    }
                }
        );

        //setupReturnButton();
    }
/*
    private void setupReturnButton() {
        Button btn = (Button) findViewById(R.id.returnColor);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int userNumber = hexValue;

                Intent intent = new Intent();
                intent.setClassName("com.example.nate.colorgrabber", "com.example.nate.colorgrabber.MainActivity");
                intent.putExtra("Parameter name", userNumber);
                startActivity(intent);
            }
        });

    }*/

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
