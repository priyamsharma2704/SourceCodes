package com.example.priyam.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner movie_spinner,rate_spinner;
    String movie_name,movie_rate;


    Button nxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      NEXT button to go to next page

        nxt = (Button)findViewById(R.id.button_next_id);
        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt = new Intent(MainActivity.this, MainActivity_2.class);//to link the button with next page
                movie_name = movie_spinner.getSelectedItem().toString();//to store the selected value from spinner into a string
                nxt.putExtra("movie_name",movie_name);// to send the selected value from spinner to the next page
                movie_rate= rate_spinner.getSelectedItem().toString();
                nxt.putExtra("movie_rate",movie_rate);
                startActivity(nxt);

            }
        });

//      SPINNER MOVIE NAMES
        movie_spinner = (Spinner)findViewById(R.id.movie_spinner_id);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.movie_names,android.R.layout.simple_spinner_dropdown_item);
        movie_spinner.setAdapter(adapter);
        movie_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " is Selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


//      SPINNER for seat rates
        rate_spinner = (Spinner)findViewById(R.id.spinner_price);
        ArrayAdapter adptr = ArrayAdapter.createFromResource(this,R.array.movie_rates,android.R.layout.simple_spinner_dropdown_item);
        rate_spinner.setAdapter(adptr);
        rate_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+"is selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
