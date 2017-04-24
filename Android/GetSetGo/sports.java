package com.example.priyam.getsetgo;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class sports extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sports);

        List<String> list = Arrays.asList(getResources().getStringArray(R.array.sports_news)); // converting array into ListView
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_list_view, R.id.id_listView, list));
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent i;
        switch(position){
            case 0 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://scores.espn.go.com/ncb/recap?gameId=400825744"));
                startActivity(i);
                break;
            case 1 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.bbc.com/sport/rugby-union/35016402"));
                startActivity(i);
                break;
            case 2 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://indianexpress.com/article/sports/cricket/india-vs-south-africa-virat-kohli-ajinkya-rahane-extend-indias-lead-to-403-against-south-africa/"));
                startActivity(i);
                break;
            case 3 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://indianexpress.com/article/sports/tennis/andy-murray-leads-britain-to-first-davis-cup-title-in-79-years/#sthash.vYSZbmTe.dpuf"));
                startActivity(i);
                break;
            case 4 : i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sports.yahoo.com/blogs/ncaaf-dr-saturday/77-teams-reach-six-wins--3-5-win-teams-to-play-in-bowls-165037893.html"));
                startActivity(i);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sports, menu);
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
