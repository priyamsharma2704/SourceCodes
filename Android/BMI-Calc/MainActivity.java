package com.example.priyam.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText weight;
    EditText height;
    TextView bmi_res;
    TextView category;
    Button calc;
    RadioGroup units;
    RadioButton rb_eng;
    RadioButton rb_metric;
    double wt,ht,bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         weight = (EditText)findViewById(R.id.id_weight);
         height = (EditText)findViewById(R.id.id_height);
         bmi_res = (TextView)findViewById(R.id.bmi_result);
         category = (TextView)findViewById(R.id.id_category);
         calc = (Button)findViewById(R.id.id_button_calc);
         units = (RadioGroup)findViewById(R.id.id_radio_grp);
         rb_eng = (RadioButton)findViewById(R.id.id_rb_English);
         rb_metric = (RadioButton)findViewById(R.id.id_rb_metric);


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //wt = Double.parseDouble(weight.getText().toString());
                //ht = Double.parseDouble(height.getText().toString());
                try
                {
                    wt = Double.parseDouble(weight.getText().toString());
                    ht = Double.parseDouble(height.getText().toString());

                } // end try
                catch (NumberFormatException e)
                {
                    Toast.makeText(MainActivity.this,"Enter Valid Input ",Toast.LENGTH_LONG).show(); // default if an exception occurs
                }

                //Checking for the radio buttion selection
                if(rb_eng.isChecked()){
                    bmi = (wt*703)/(ht*ht);
                }
                else if(rb_metric.isChecked()){
                    bmi = (wt/(ht*ht));
                }

                //Printing the BMI value
                bmi_res.setText("BMI = "+bmi);

                //Checking for the categories
                if(bmi >= 30.0)
                    category.setText("OBESE");
                else if(bmi < 29.9 && bmi > 25.0)
                    category.setText("OVER WEIGHT");
                else if(bmi > 18 && bmi < 24.9 )
                    category.setText("NORMAL");
                else if (bmi > 0 && bmi <18)
                    category.setText("UNDER WEIGHT");


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
