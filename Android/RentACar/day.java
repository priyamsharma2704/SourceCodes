package com.example.priyam.rentacar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class day extends AppCompatActivity {

    Button back,cal;
    TextView cost;
    EditText days;
    double rate,no_of_days,final_cost;
    String car_name,value;

    //Main m = new Main();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        back = (Button)findViewById(R.id.id_button_BACK);
        cal = (Button)findViewById(R.id.id_button_cost);
        cost = (TextView)findViewById(R.id.id_final_cost);
        days = (EditText)findViewById(R.id.id_no_of_days);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(day.this,Main.class);
                startActivity(i);
            }
        });

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent();
                no_of_days = Double.parseDouble(days.getText().toString());
                car_name = getIntent().getExtras().getString("cars_name");


                if (car_name.equals("MERC C-Class( $15 per day)")){
                    rate = 15;

                }
                else if (car_name.equals("AUDI A4 ( $17 per day)")){
                    rate =17;

                }

                else if (car_name.equals("BMW 3-Series ( $20 per day)")){
                    rate =20;

                }

                else if (car_name.equals("JAGUAR ( $18 per day)")){
                    rate =18;

                }

                else if (car_name.equals("LAND ROVER ( $25 per day)")){
                    rate =25;

                }

                else if (car_name.equals("LAMBO ( $50 per day)")){
                    rate =50;

                }






                final_cost = no_of_days*rate;

                cost.setText("CARS = " + car_name + " | " + " DAYS = " + no_of_days + " | " + "COST = $" + final_cost);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_day, menu);
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
