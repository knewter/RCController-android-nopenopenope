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

  private void handleStick(VerticalSeekBar stick, final TextView valueText) {
    stick.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
      @Override
      public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        Log.d(TAG, Integer.toString(i));
        valueText.setText(Integer.toString(i));
      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {

      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

      }
    });
  }

}
