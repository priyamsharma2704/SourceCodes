package com.example.priyam.currencyconvertor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double final_rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Spinner currency = (Spinner)findViewById(R.id.spinner_currency_select);
        TextView dollar = (TextView)findViewById(R.id.id_dollar);
        final EditText input_dollar = (EditText)findViewById(R.id.id_input_dollar);
        final TextView result = (TextView)findViewById(R.id.id_result);
        Button convert = (Button)findViewById(R.id.button_convert);
        TextView rates = (TextView)findViewById(R.id.id_currency_rates);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.currency,android.R.layout.simple_spinner_dropdown_item);
        currency.setAdapter(adapter);
        currency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast msg = Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " is Selected", Toast.LENGTH_SHORT);

                msg.setGravity(Gravity.BOTTOM,0,0);
                msg.show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double input = Double.parseDouble(input_dollar.getText().toString());
                if(currency.getSelectedItem().equals("EURO")){
                    final_rate = input*75;
                }
                else if(currency.getSelectedItem().equals("RUPEE")){
                    final_rate = input*65;
                }
                else if(currency.getSelectedItem().equals("DINAR")){
                    final_rate = input*100;
                }
                else if(currency.getSelectedItem().equals("YEN")){
                    final_rate=input*80;
                }


                result.setText(String.valueOf(final_rate));

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
