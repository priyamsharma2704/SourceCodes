package com.example.priyam.getsetgo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.ButtonBarLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class TitleScreen extends AppCompatActivity {
    ImageButton music_btn,trending_btn, food_btn,sports_btn,technology_bnt,entertainment_btn,fashion_btn;
    TextView contactUs,aboutUs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);
        music_btn = (ImageButton)findViewById(R.id.id_green_btn);
        trending_btn = (ImageButton)findViewById(R.id.id_blue_btn);
        food_btn = (ImageButton)findViewById(R.id.id_yellow_btn);
        sports_btn = (ImageButton)findViewById(R.id.id_khakee_brn);
        technology_bnt = (ImageButton)findViewById(R.id.id_purple_btn);
        entertainment_btn = (ImageButton)findViewById(R.id.id_reb_btn);
        fashion_btn = (ImageButton)findViewById(R.id.id_grey_btn);

        contactUs = (TextView)findViewById(R.id.id_contact_us);
        aboutUs = (TextView)findViewById(R.id.id_about_us);

       // Temp commented the music tab to avoid lag....Remove comment when app is ready

        music_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TitleScreen.this,musicLibrary.class);
                startActivity(i);
            }
        });

        trending_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TitleScreen.this,trendingNews.class);
                startActivity(i);
            }
        });

        food_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TitleScreen.this,food.class);
                startActivity(i);
            }
        });

        sports_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TitleScreen.this,sports.class);
                startActivity(i);
            }
        });

        technology_bnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TitleScreen.this,technology.class);
                startActivity(i);
            }
        });

        entertainment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TitleScreen.this, entertainment.class);
                startActivity(i);
            }
        });


        fashion_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TitleScreen.this, fashion.class);
                startActivity(i);
            }
        });

        contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TitleScreen.this, contact.class);
                startActivity(i);

            }
        });

        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TitleScreen.this, about.class);
                startActivity(i);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_title_screen, menu);
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
