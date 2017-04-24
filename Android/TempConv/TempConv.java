package com.example.priyam.tempconv;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class TempConv extends AppCompatActivity {

    EditText temp;
    TextView result;
    Button conv;
    Spinner degree;
    double in_value;


    //String input;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_conv);
        temp = (EditText)findViewById(R.id.id_temp_value);
        result = (TextView)findViewById(R.id.id_result);
        degree = (Spinner)findViewById(R.id.spinner_degree_sel);
        conv = (Button)findViewById(R.id.button_convert);


        //input= temp.getText().toString();
        //try{
            //in_value = Double.parseDouble(temp.getText().toString());
        //}
        //catch(NumberFormatException e){
        //    in_value = 0;
        //}

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.degre_sel,android.R.layout.simple_spinner_dropdown_item);
        degree.setAdapter(adapter);
        degree.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " is selected ", Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        conv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent i= new Intent(this.)

                if(degree.getSelectedItem().toString().equals("Celsius to Fahrenheit")){
                    //result.setText(String.valueOf(c2f(in_value)));
                    //c2f = ((9/5)*in_value + 32);
                    in_value = Double.parseDouble(temp.getText().toString());
                    result.setText(String.valueOf(c2f(in_value)));
                    //c2f(in_value);
                    //result.setText("yweaaa");
                }
                else {
                    in_value = Double.parseDouble(temp.getText().toString());
                    result.setText(String.valueOf(f2c(in_value)));
                    //result.setText(String.valueOf(f2c(in_value)));
                    //f2c = ((in_value-32)*(5/9));
                    //f2c(in_value);
                    //result.setText("noooooo");*/
                }
            }
        });
    }

    public double c2f(double a)
    {
        return (((9*a)/5) + 32);
        //double z =(9/5)*a + 32;
        //result.setText(String.valueOf(c2f(z)));
    }
    public double f2c(double b)
    {
        //return (b*12);
        return((b-32)*(1.8));
        //double y =(a-32)*(5/9);
        //result.setText(String.valueOf(f2c(y)));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_temp_conv, menu);
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
