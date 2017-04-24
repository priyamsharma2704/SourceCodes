package com.example.priyam.tipcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    NumberFormat percentage = NumberFormat.getPercentInstance();
    double billAmount = 0.0;
    double customPercent = 0.18;

    EditText amount;
    SeekBar customTip;
    TextView amountDisplayTextView;
    TextView percentCustomTextView;
    TextView tip15TextView;
    TextView total15TextView;
    TextView tipCustomTextView;
    TextView totalCustomTextView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amount = (EditText)findViewById(R.id.id_amount);
        customTip = (SeekBar)findViewById(R.id.customSeekBar);
        amountDisplayTextView = (TextView)findViewById(R.id.amountDisplayTextView);
        percentCustomTextView = (TextView)findViewById(R.id.percent18TextView);
        tip15TextView = (TextView)findViewById(R.id.tip15TextView);
        totalCustomTextView = (TextView)findViewById(R.id.totalCustomTextView);
        tipCustomTextView = (TextView)findViewById(R.id.tipCustomLayout);
        totalCustomTextView = (TextView)findViewById(R.id.totalCustomTextView);

        amountDisplayTextView.setText(currency.format(billAmount));
        updateStandard();
        updateCustom();

        //amount = (EditText)findViewById(R.id.id_amount);
        amount.addTextChangedListener(amountEditTextWatcher);
        customTip.setOnSeekBarChangeListener(customSeekBarListener);



    }
    private void updateStandard(){
        double fifteenPercentTip = billAmount *0.15;
        double fifteenPercentTotal = billAmount + fifteenPercentTip;
        tip15TextView.setText(currency.format(fifteenPercentTip));
        total15TextView.setText(currency.format(fifteenPercentTotal));
    }
    private void updateCustom(){
        percentCustomTextView.setText(percentage.format(customPercent));
        double customTip = billAmount * customPercent;
        double customTotal = billAmount * customTip;

        tipCustomTextView.setText(currency.format(customTip));
        tipCustomTextView.setText(currency.format(customTotal));
    }
    private SeekBar.OnSeekBarChangeListener customSeekBarListener =
            new SeekBar.OnSeekBarChangeListener()
            {
                // update customPercent, then call updateCustom
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser)
                {
                    // sets customPercent to position of the SeekBar's thumb
                    customPercent = progress / 100.0;
                    updateCustom(); // update the custom tip TextViews
                } // end method onProgressChanged

                @Override
                public void onStartTrackingTouch(SeekBar seekBar)
                {
                } // end method onStartTrackingTouch

                @Override
                public void onStopTrackingTouch(SeekBar seekBar)
                {
                } // end method onStopTrackingTouch
            }; // end OnSeekBarChangeListener

    private TextWatcher amountEditTextWatcher = new TextWatcher()
    {
        // called when the user enters a number
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count)
        {
            // convert amountEditText's text to a double
            try
            {
                billAmount = Double.parseDouble(s.toString()) / 100.0;
            } // end try
            catch (NumberFormatException e)
            {
                billAmount = 0.0; // default if an exception occurs
            } // end catch

            // display currency formatted bill amount
            amountDisplayTextView.setText(currency.format(billAmount));
            updateStandard(); // update the 15% tip TextViews
            updateCustom(); // update the custom tip TextViews
        } // end method onTextChanged

        @Override
        public void afterTextChanged(android.text.Editable s)
        {
        } // end method afterTextChanged

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after)
        {
        } // end method beforeTextChanged
    }; // end amountEditTextWatcher


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
