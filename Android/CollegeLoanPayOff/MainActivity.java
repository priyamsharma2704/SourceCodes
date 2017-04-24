package com.example.priyam.collegeloanpayoffcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;
import  java.lang.Math;

public class MainActivity extends AppCompatActivity {

    NumberFormat currency = NumberFormat.getCurrencyInstance(); // Printing the input amount in proper format
    TextView input;
    EditText loan_amnt;
    TextView loan_amnt_disp;
    SeekBar seek_bar;
    TextView intrst;
    Spinner term;
    Button calc;
    TextView result;
    int i,rate,time,n;
    double j,loan,k,t;
    double amount ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (TextView)findViewById(R.id.id_edit_loan_amnt);
        loan_amnt = (EditText)findViewById(R.id.id_edit_loan_amnt);
        loan_amnt_disp = (TextView)findViewById(R.id.id_loan_amnt_display);
        seek_bar = (SeekBar)findViewById(R.id.seekBar);
        intrst = (TextView)findViewById(R.id.id_txt_intrst_rate);
        term = (Spinner)findViewById(R.id.spinner);
        calc = (Button)findViewById(R.id.id_button_Calc);
        result = (TextView)findViewById(R.id.id_txt_result);

        TextWatcher loan_amnt_txt_watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try
                {
                    amount = Double.parseDouble(s.toString()) / 100.0;  // getting the input amount value
                } // end try
                catch (NumberFormatException e)
                {
                    Toast.makeText(MainActivity.this,"Enter Valid Amount",Toast.LENGTH_LONG).show();// default if an exception occurs
                } // end catch
                loan_amnt_disp.setText(currency.format(amount)); // Printing the input amount in currency format
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        };
        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                i = progress;
                intrst.setText(i + "%"); //printing the value of interest rate
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.loan_term, android.R.layout.simple_spinner_dropdown_item);//Linking the spinner and the array string with the help of adapter
        term.setAdapter(adapter);
        loan_amnt.addTextChangedListener(loan_amnt_txt_watcher); // Calling textwatcher
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rate = seek_bar.getProgress();  // To get interest rate value

                //If condition to find out the term period
                if(term.getSelectedItem().toString().equals("5 Yrs")){
                    time=5;
                }
                else if (term.getSelectedItem().equals("10 Yrs")){
                    time=10;
                }
                else if (term.getSelectedItem().equals("15 Yrs")){
                    time=15;
                }
                else if (term.getSelectedItem().equals("20 Yrs")){
                    time = 20;
                }
                else if (term.getSelectedItem().equals("25 Yrs")){
                    time = 25;
                }
                else if (term.getSelectedItem().equals("30 Yrs")){
                    time = 30;
                }

                j = rate/(12.0*100); // monthly inter rate
                n = time *12;  // no. of payments
                k = 1+j;
                t = Math.pow(k,n);  // math.pow function for calculating th exponent value
                loan = (amount * j * t )/(t-1);  // monthly payments
                result.setText("EMI = " + currency.format(loan));


            }
        });


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
