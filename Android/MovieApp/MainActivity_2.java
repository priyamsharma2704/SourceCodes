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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_2 extends MainActivity {

    Button back,finish;
    Spinner show_time_spinner;
    TextView summary;

    int num;
    double total;
    double price = 3.00;
    String show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

//      SPINNER SHOW TIMINGS
        show_time_spinner = (Spinner)findViewById(R.id.show_spinner_id);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this,R.array.show_times,android.R.layout.simple_spinner_dropdown_item);
        show_time_spinner.setAdapter(adapter1);
        show_time_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " is selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//      BACK BUTTON to go back to first page
        back = (Button)findViewById(R.id.button_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_back = new Intent(MainActivity_2.this,MainActivity.class);// linking the first page with BACK button
                startActivity(i_back);
            }
        });


//      FINISH button
        finish = (Button)findViewById(R.id.button_finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                summary = (TextView)findViewById(R.id.summary_id);
                show = show_time_spinner.getSelectedItem().toString();// to store the selected item from the spinner into the string
                summary.setText("Show = "+(getIntent().getExtras().getString("movie_name"))+ " | Class = " +(getIntent().getExtras().getString("movie_rate")) + " | time = " + show);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity_2, menu);
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
