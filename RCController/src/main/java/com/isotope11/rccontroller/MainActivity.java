package com.isotope11.rccontroller;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VerticalSeekBar;

public class MainActivity extends Activity {

  protected final String TAG = MainActivity.class.toString();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    VerticalSeekBar leftStick = (VerticalSeekBar) findViewById(R.id.leftStick);
    VerticalSeekBar rightStick = (VerticalSeekBar) findViewById(R.id.rightStick);
    TextView leftValue = (TextView) findViewById(R.id.leftValue);
    TextView rightValue = (TextView) findViewById(R.id.rightValue);
    handleStick(leftStick, leftValue);
    handleStick(rightStick, rightValue);
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  private void handleStick(final VerticalSeekBar stick, final TextView valueText) {
    stick.setProgress(50);
    valueText.setText(Double.toString(mapStickValueToMotorValue(50)));
    stick.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        Log.d(TAG, Integer.toString(i));
        valueText.setText(Double.toString(mapStickValueToMotorValue(i)));
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {
        // NOTE: This should happen, but it moves the thumb to the bottom for some inexplicable reason
        stick.setProgress(50);
        valueText.setText(Double.toString(mapStickValueToMotorValue(50)));
      }
    });
  }
  protected double mapStickValueToMotorValue(int stickValue) {
    double middle = 50;
    double middleMapped = (double) stickValue - middle;
    return middleMapped / middle;
  }
}
