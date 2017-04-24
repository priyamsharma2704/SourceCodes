package com.example.priyam.getsetgo;

import android.app.ListActivity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class musicLibrary extends ListActivity {

    String a;
    String songList[] = {
            "Define Light - Strength",
            "Enigma - Loneliness",
            "FuzzCulture - Godzilla",
            "Led Zepplin - Kashmir",
            "Linkin Park - Shadow Of The Day",
            "Simpla Plan - Saturday",
            "Muthmath - Typical"};

    ImageButton play,pause;
    MediaPlayer players[];  //Array for media player
    final int NUM_SONGS = 7;    // Number of songs added
    int p, pos;
    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_library);

        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,songList); // Attaching the string array with the list view
        setListAdapter(ad);

        play = (ImageButton)findViewById(R.id.id_play_btn);
        pause = (ImageButton)findViewById(R.id.id_pause_btn);

        players = new MediaPlayer[NUM_SONGS];

        players[0] = new MediaPlayer();                                     //Initializing the media player variables
        players[0] = MediaPlayer.create(this,R.raw.definelightstrength);    // and connecting the songs with it

        players[1] = new MediaPlayer();
        players[1] = MediaPlayer.create(this,R.raw.enigmaageofloneliness);

        players[2] = new MediaPlayer();
        players[2] = MediaPlayer.create(this,R.raw.fuzzculturegodzilla);

        players[3] = new MediaPlayer();
        players[3] = MediaPlayer.create(this,R.raw.leddepplinkashmir);

        players[4] = new MediaPlayer();
        players[4] = MediaPlayer.create(this,R.raw.linkinparkshadowoftheday);

        players[5] = new MediaPlayer();
        players[5] = MediaPlayer.create(this,R.raw.simpleplansaturday);

        players[6] = new MediaPlayer();
        players[6] = MediaPlayer.create(this,R.raw.ttypical);


        p =-1; // array index of song currently playing
        pos = -1; // index of selected song

        l = (ListView) findViewById(android.R.id.list);


        //  Play button Listner
        View.OnClickListener playListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (pos == -1)
                    Toast.makeText(musicLibrary.this, "Please select the song.", Toast.LENGTH_SHORT).show();   // Displaying TOAST message when no song is selected
                else
                {
                    if (p >= 0 && p != pos)             //PAUSE the previously playing song
                        players[p].pause();
                    p = pos;
                    a=l.getItemAtPosition(pos).toString();
                    Toast.makeText(musicLibrary.this,a + " is selected.",Toast.LENGTH_SHORT).show();       //Display the name of current selected song
                    players[p].start();     //PLAY the currently selected song
                }
            } // onClick
        };
        play.setOnClickListener(playListener);


        //PAUSE button listener
        View.OnClickListener pauseListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (p == -1)
                    Toast.makeText(musicLibrary.this, "Please select the song.", Toast.LENGTH_SHORT).show();       // Displaying TOAST message when no song is selected
                else
                {
                    players[p].pause();             //PAUSE the song when PAUSE button is clicked
                }
            }
        };
        pause.setOnClickListener(pauseListener);

        // ListView listener
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pos = position;
            }
        });







    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_music_library, menu);
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
