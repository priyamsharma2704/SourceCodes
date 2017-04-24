package com.example.priyam.udguide;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.Arrays;
import java.util.List;

public class SitesOfInterest extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<String> websites = Arrays.asList(getResources().getStringArray(R.array.sites_of_int));  // converting array into ListView
        setListAdapter(new ArrayAdapter<String>(this,R.layout.activity_sites_of_interest, R.id.id_sites_of_interest, websites));// Putting it in the layout of sites of interest
    } // end of onCreate

    protected void onListItemClick(ListView l,View v,int position,long id){
        Intent intent;
        switch (position){
            case 0 : intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.udayton.edu/")); // opening the link
                startActivity(intent);
                break;
            case  1 : intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.udayton.edu/apply/index.php"));
                startActivity(intent);
                break;
            case  2 : intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.udayton.edu/academics/index.php"));
                startActivity(intent);
                break;
            case  3 : intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.udayton.edu/lead/index.php"));
                startActivity(intent);
                break;
            case  4 : intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.udayton.edu/life/index.php"));
                startActivity(intent);
                break;
            case  5 : intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.udayton.edu/athletics/index.php"));
                startActivity(intent);
                break;
            case  6 : intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.udayton.edu/news/"));
                startActivity(intent);
                break;
            case  7 : intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.udayton.edu/calendar/"));
                startActivity(intent);
                break;
            case  8 : intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.udayton.edu/libraries/"));
                startActivity(intent);
                break;
            case  9 : intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.udayton.edu/contact.php"));
                startActivity(intent);
                break;

        }
    }// end of onListItemClick


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sites_of_interest, menu);
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
